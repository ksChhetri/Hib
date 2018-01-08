package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class Level1CacheTest {

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
		 
		//Load object 
		details=ses.load(EmpDetails.class,1001);
		try{
		  tx=ses.beginTransaction();
		    details.setFname("Rajesh");
		    details.setLname("rao");
		    details.setLname("rao1");
		    details.setMail("rao@1.com");
		  tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class
