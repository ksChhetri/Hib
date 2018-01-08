package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class VersionTest {

	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//save object
		 details=new EmpDetails();
		 details.setNo(1001);
		 details.setFname("raja");
		 details.setLname("rao");
		 details.setMail("rao@gmail.com");
		try{
		 tx=ses.beginTransaction();
		  int idVal=(Integer)ses.save(details);
		  System.out.println("Id value"+idVal);
		 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();	
		}
		System.out.println("Object Version:::"+details.getVer());
		//close Session
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
