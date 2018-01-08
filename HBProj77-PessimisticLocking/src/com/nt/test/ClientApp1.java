package com.nt.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ClientApp1 {

	public static void main(String[] args)throws Exception {
		 Session ses=null;
		 EmpDetails ed=null;
		 Transaction tx=null;
		// get Session
		 ses=HibernateUtil.getSession();
		//Load object
		 ed=ses.get(EmpDetails.class,102,LockMode.UPGRADE_NOWAIT);
		 //modify object
		 try{
			tx=ses.beginTransaction();
			    ed.setMail("raja@yyy6.com");
			    ses.update(ed);
				System.out.println("ClientApp1::::Object updated.... and went to sleep state");
			    Thread.sleep(40000);
			tx.commit();
		 }//try
		 catch(Exception e){
			 tx.rollback();
			 e.printStackTrace();
		 }
		 
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}
}
