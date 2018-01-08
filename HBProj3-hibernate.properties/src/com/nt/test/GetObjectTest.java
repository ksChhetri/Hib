package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class GetObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//add mapping file
		cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		 
		//Load object 
		details=ses.get(EmpDetails.class,9867);
		if(details!=null)
			System.out.println(details.getNo()+"  "+details.getFname()+"  "+details.getLname()+"  "+details.getMail());
		else
		  System.out.println("Record not found");
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class
