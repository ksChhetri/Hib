package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest {

	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		String idval=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//save object
		details=new EmpDetails();
		//details.setNo(1235);
		details.setFname("karan");
		details.setLname("rao");
		details.setMail("rao@gmail.com");
		try{
		 tx=ses.beginTransaction();
		  idval=(String)ses.save(details);
		  System.out.println("Generated id value:::"+idval);
          tx.commit();		  
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
	/*	try{
		   tx=ses.beginTransaction();
			 ses.persist(details);
          tx.commit();		  
          System.out.println("object is saved");
			}//try
			catch(Exception e){
				tx.rollback();
				e.printStackTrace();
			}*/
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

	}//main
}//class
