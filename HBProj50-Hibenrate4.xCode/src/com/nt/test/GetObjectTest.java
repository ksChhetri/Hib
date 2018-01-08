package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.domain.EmpDetails;

public class GetObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//read both xml files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		//factory=cfg.buildSessionFactory();  //deprecated in hibenrate 4.x
		     //create ServiceRegistryBuiler
		builder=new StandardServiceRegistryBuilder();
		//create SErvice Registry
		registry=builder.applySettings(cfg.getProperties()).build();
		//build SessionFactory
		factory=cfg.buildSessionFactory(registry);
		
		//create Session
		ses=factory.openSession();
		 
		//Load object 
		details=(EmpDetails) ses.get(EmpDetails.class,102);
		//details.getFname();
		if(details!=null)
			System.out.println(details.getNo()+"  "+details.getFname()+"  "+details.getLname()+"  "+details.getMail());
		else
		  System.out.println("Record not found");
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class
