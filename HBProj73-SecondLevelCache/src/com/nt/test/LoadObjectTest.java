package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class LoadObjectTest {

	public static void main(String[] args) throws Exception{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses1=null,ses2=null;
		EmpDetails details1=null,details2=null,details3=null,details4=null,details5=null,details6=null;
		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//read both xml files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//create Session
		ses1=factory.openSession();
		ses2=factory.openSession();
		//Loads obj from DB s/w  and keeps in L2 cache, L1 cache(ses1)
		details1=ses1.get(EmpDetails.class,102);
		System.out.println("details1::"+details1);
		System.out.println("------------------------------------------------------");
		//Loads object L1 cache(ses1)
		details2=ses1.get(EmpDetails.class, 102);
		System.out.println("details2::"+ details2);
		//removes obj from L1 cache
		ses1.evict(details1);
		//Loads obj from L2 cache and keeps in L1 cache (ses1)
		details3=ses1.get(EmpDetails.class,102);
		System.out.println("details3::"+details3);
		//Loads obj from  L1 cache
		details4=ses1.get(EmpDetails.class,102);
		System.out.println("details4::"+details4);
		ses1.clear(); // clears L1 cache of ses1 
		Thread.sleep(15000);  // Becoz of idle time that obj will be removed from L2 cache
		//Loads obj from DB and keeps  L2 cache and in L1 cache of ses2
		details5=ses2.get(EmpDetails.class,102);
		System.out.println("details5::"+details5);
		ses2.clear();  //removes obj from L1 cache of ses2
		//Loads obj  L2 cache and in L1 cache of ses1
		details6=ses1.get(EmpDetails.class,102);
		System.out.println("details6::"+details6);
		
		//close objs
		ses1.close();
		ses2.close();
		factory.close();
	}//main
}//class
