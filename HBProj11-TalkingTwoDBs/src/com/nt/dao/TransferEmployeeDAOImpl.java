package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.MySqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferEmployeeDAOImpl implements TransferEmployeeDAO {

	@Override
	public boolean transfer(int eid) {
		Session oraSes=null,mysqlSes=null;
		EmpDetails details1=null;
		Transaction tx=null;
		boolean flag=false;
		// get Sessions
		oraSes=OracleHibernateUtil.getSession();
		mysqlSes=MySqlHibernateUtil.getSession();
		//load from object from oracle
		details1=oraSes.get(EmpDetails.class,1001);
		//save object in mysql
		try{
		 tx=mysqlSes.beginTransaction();
		  mysqlSes.save(details1);
		 tx.commit();
		 flag=true;
		}//try
		catch(Exception e){
            tx.rollback();
           flag=false;
		}
		//delte object form Oracle 
		try{
			 tx=oraSes.beginTransaction();
			  oraSes.delete(details1);
			 tx.commit();
			 flag=true;
			}//try
			catch(Exception e){
	            tx.rollback();
	            flag=false;
			}
		
		return flag;
		
	}//method
}//class
