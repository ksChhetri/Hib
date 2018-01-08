package com.nt.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class TimeStampTest1 {
	
	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//Get session
		ses=HibernateUtil.getSession();
		//Load object
		details=ses.get(EmpDetails.class,4567);
		try{
	     tx=ses.beginTransaction();
	        details.setMail("rx2@gmail.com");
	     tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		System.out.println("Object is lastly Updated at"+details.getLastUpdated());
		 //close objects
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
