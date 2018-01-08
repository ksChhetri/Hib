package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class MergeTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses1=null,ses2=null;
		EmpDetails details1=null,details2=null,details3=null;
		Transaction tx=null;
		//create SessionFactory object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
        //create Session
		ses1=factory.openSession();
		ses2=factory.openSession();
		
		//Load object using session1(ses1)
		details1=ses1.get(EmpDetails.class,1001); //persistent 
		System.out.println("ses1-->"+details1);
		ses1.close(); // detached
		
		//Load object using session2(ses2)
		details2=ses2.get(EmpDetails.class,1001); //persistent
		System.out.println("ses2+-->"+details2);
		//make details1 objs persistent obj using ses2
		try{
	      tx=ses2.beginTransaction();	
	        details1.setMail("116@456.com");
	       details3=(EmpDetails)ses2.merge(details1);
          tx.commit();
          System.out.println("after merge()"+details3);	       
      	  System.out.println("Detached obj has become pesistent object");
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		
		//close objs
		ses2.close();
		factory.close();
	}//main
}//class
