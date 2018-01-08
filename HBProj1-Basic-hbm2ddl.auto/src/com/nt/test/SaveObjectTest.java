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
		
		//create Session
		ses=factory.openSession();
		//create Domain class object
		details=new EmpDetails();
		details.setNo(1079); details.setFname("raja3");
		details.setLname("rao3"); details.setMail("rao9@gmail.com");
		//Save object..
		try{
		 Thread.sleep(30000);
		 tx=ses.beginTransaction(); //begin Tx
		 int idval=(Integer)ses.save(details);
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
