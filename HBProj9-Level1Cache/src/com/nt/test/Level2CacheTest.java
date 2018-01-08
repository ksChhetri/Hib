package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class Level2CacheTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null,details1=null,details2=null;
		Transaction tx=null;
		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//read both xml files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		 
		//Loads from DB and keeps in L1 cache
		details=ses.get(EmpDetails.class,1001);
		System.out.println(details);
		System.out.println("------------------");
		//Loads from L1 cache
		details1=ses.get(EmpDetails.class,1001);
		System.out.println(details);
		System.out.println("-------------------");
		//remove from L1 cache
		ses.evict(details);
		//Loads from DB  and keeps in L1 cache
		details2=ses.get(EmpDetails.class,1001);
		System.out.println(details2);
		System.out.println("-------------------");
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class
