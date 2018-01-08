package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class VersionTest1 {

	public static void main(String[] args) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object
		details=ses.get(EmpDetails.class,1001);
		try{
		tx=ses.beginTransaction();
		 details.setMail("x@y3.com");
		tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		System.out.println("Object is modified for"+details.getVer()+"times");
			//close Object
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
