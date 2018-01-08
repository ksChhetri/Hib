package com.nt.test;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class TimeStampTest {
	
	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//Get session
		ses=HibernateUtil.getSession();
		//Save object
		 details=new EmpDetails();
		 details.setNo(4567);
		 details.setFname("raja");
		 details.setLname("rao");
		 details.setMail("rao@gmail.com");
		 try{
		  tx=ses.beginTransaction();
		    ses.save(details);
		  tx.commit();
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
		 System.out.println("Object is saved at"+details.getLastUpdated());
		 //close objects
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}//main
}//class
