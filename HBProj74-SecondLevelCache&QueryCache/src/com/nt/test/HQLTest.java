package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class HQLTest {

	public static void main(String[] args) throws Exception{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Query query1=null;
		List<EmpDetails> list=null;
		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//read both xml files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//prepare and execute HQL Query
		query1=ses.createQuery("from EmpDetails");
		query1.setCacheable(true);
		query1.setCacheRegion("region1");
		list=query1.list();
		for(EmpDetails details:list){
			System.out.println(details);
		}
		System.out.println("----------------------------------------------");
		list=query1.list();
		for(EmpDetails details:list){
			System.out.println(details);
		}
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
