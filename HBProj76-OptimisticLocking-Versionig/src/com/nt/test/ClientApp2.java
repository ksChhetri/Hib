package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ClientApp2 {

	public static void main(String[] args)throws Exception {
		 Session ses=null;
		 EmpDetails ed=null;
		 Transaction tx=null;
		// get Session
		 ses=HibernateUtil.getSession();
		//Load object
		 ed=ses.get(EmpDetails.class,102);
		 //modify object
		 try{
			tx=ses.beginTransaction();
			    ed.setMail("raja@yyy5.com");
			    ses.update(ed);
			tx.commit();
			System.out.println("Client2:::::Object updated");
		 }//try
		 catch(Exception e){
			 tx.rollback();
			 e.printStackTrace();
		 }
		 
		 HibernateUtil.closeSession();
		 HibernateUtil.closeSessionFactory();
	}
}
