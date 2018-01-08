package com.nt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements BankDAO {
   private static final String  WIDTHDRAW_QUERY="update Account set balance=balance-:amt where acno=:srcNo";
   private static final String  DEPOSITE_QUERY="update Account set balance=balance+:amt where acno=:destNo";
	
   @Override
	public int transferMoney(int srcNo, int destNo, int amt) {
	   Query query1=null,query2=null;
	   Session ses=null;
	   Transaction tx=null;
	   int result1=0,result2=0;
	   //get Session
	   ses=HibernateUtil.getSession();
	   //prepare Query objs
	   query1=ses.createQuery(WIDTHDRAW_QUERY);
	   query1.setInteger("amt",amt);
	   query1.setInteger("srcNo",srcNo);
	   
	   query2=ses.createQuery(DEPOSITE_QUERY);
	   query2.setInteger("amt",amt);
	   query2.setInteger("destNo",destNo);
	   
	   try{
		   tx=ses.beginTransaction();
	         	result1=	query1.executeUpdate();
		       result2=query2.executeUpdate();
		       if(result1!=0 && result2!=0){
                   tx.commit();
                   return 1;
		       }
		       else{
		    	   tx.rollback();
		    	   return 0;
		       }
	   }//try
	   catch(Exception e){
		   tx.rollback();
		   return 0;
	   }
	}//method
}//class
