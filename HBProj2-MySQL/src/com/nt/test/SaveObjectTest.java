package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//read both xml files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		System.out.println("SessionFactory obj class "+factory.getClass());
		
		//create Session
		ses=factory.openSession();
		System.out.println("session object class::"+ses.getClass());
		//create Domain class object
		details=new EmpDetails();
		details.setNo(1071); details.setFname("raja2");
		details.setLname("rao2"); details.setMail("rao2@gmail.com");
		
		//Save object..
		try{
		 tx=ses.beginTransaction(); //begin Tx
		 int idval=(Integer)ses.save(details);
		 System.out.println("Generated id value:::"+idval);
		 tx.commit(); //commit Tx
		  System.out.println("Object is saved"); 
		}//try
		catch(Exception e){
			tx.rollback(); //rollback Tx
		}
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class
