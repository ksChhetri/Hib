package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class ORMSynchronizationTest {
	public static void main(String[] args) {
		Session ses=null;
		SessionFactory factory=null;
		EmpDetails details=null;
		Transaction tx=null;
		//create Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		ses=factory.openSession();
	/*	//Syncrhronzation between Object to Db table row
		   //load object
		details=ses.get(EmpDetails.class,9867);
		 //modify the object in a Transaction
		try{
		 tx=ses.beginTransaction();
		   details.setMail("x@y1.com");
		 tx.commit();
		 System.out.println("Object is modified");
		}//try
		catch(Exception e){
			tx.rollback();
		}*/
		
		//Syncrhronzation between Db table row to object
		//load object
		details=ses.get(EmpDetails.class,9867);
		System.out.println(details);
		try{
		 Thread.sleep(40000);  //Modify DB table data from SQL promt	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ses.refresh(details); //realoding object
		System.out.println(details);
		
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
