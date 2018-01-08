package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class MergeTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null,details1=null;
		Transaction tx=null;
		//create SessionFactory object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
        //create Session
		ses=factory.openSession();
		//prepare object
		details=new EmpDetails();
		details.setNo(9867);
		details.setFname("ramesh3");
		details.setLname("rao1");
		details.setMail("rao@gmail.com");
		try{
		 tx=ses.beginTransaction();
		 details1=(EmpDetails)ses.merge(details);
		 tx.commit();
		 System.out.println("Object is saved/updated");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
