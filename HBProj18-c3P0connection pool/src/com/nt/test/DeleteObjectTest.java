package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class DeleteObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		SessionFactory factory=null;
		EmpDetails details=null;
		Transaction tx=null;
		//create Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		ses=factory.openSession();
		/*//delete Object (Version1)
		details=new EmpDetails();
		 details.setNo(1001);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(details);
		 tx.commit();
		 System.out.println("Object deleted");
		}
		catch(Exception e){
			tx.rollback();
		}*/
		
		//delete object (version2)
		   //load object
		details=ses.get(EmpDetails.class,1002);
		if(details!=null){
          try{
        	 tx=ses.beginTransaction();
        	  ses.delete(details);
        	 tx.commit();
        	 System.out.println("Object deleted");
          }
          catch(Exception e){
        	  tx.rollback();
          }
		}
		else{
			System.out.println("Object is not deleted");
		}
		
		//close Session
		ses.close();
		factory.close();
	}//main
}//class
