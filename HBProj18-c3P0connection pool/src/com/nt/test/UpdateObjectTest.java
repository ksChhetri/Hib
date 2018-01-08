package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class UpdateObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		SessionFactory factory=null;
		EmpDetails details=null;
		Transaction tx=null;
		//create Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		ses=factory.openSession();
	//Update object (version1)-->Bad approacj
		details=new EmpDetails();
		details.setNo(56778);
		details.setFname("raja2");
		details.setLname("rao2");
		details.setMail("raja2@coolMail.com");
		try{
	     tx=ses.beginTransaction();
	       ses.update(details);
	     tx.commit();
	     System.out.println("Object updated");
		}
		catch(Exception e){
		  tx.rollback();
		} 
		
	/*	//Updating object (version2)-->Good pratice
		  //load object
		details=ses.get(EmpDetails.class,9877);
		if(details!=null){
		  try{
			tx=ses.beginTransaction();
			 details.setFname("raja");
			 details.setLname("rao");
			 details.setMail("x@z.com");
			 ses.update(details);
			tx.commit();
			System.out.println("Object is updated");
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
		}//if
		else{
			System.out.println("Object not found to update");
		}
		*/
	/*	//Updating object (version3)-->Good pratice
	  //load object
		details=ses.get(EmpDetails.class,1003);
		if(details!=null){
		  try{
			tx=ses.beginTransaction();
			 details.setMail("x@z1.com");
			tx.commit();
			System.out.println("Object is updated");
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
		}//if
		else{
			System.out.println("Object not found to update");
		}*/
		
		
		//close Session
		ses.close();
		factory.close();
	}//main
}//class
