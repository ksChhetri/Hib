package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.cid.PrgmrProjId;
import com.nt.domain.ProgrammerProjectDetails;
import com.nt.utility.HibernateUtil;

public class CompositeIdTest {

	public static void main(String[] args) {
	   Session ses=null;
	   ProgrammerProjectDetails domain=null;
	   PrgmrProjId id=null,idVal=null;
	   Transaction tx=null;
		//save object
	   ses=HibernateUtil.getSession();
	   //prpeare Composite Id class object
	   id=new PrgmrProjId();
	   id.setPrgmrId(1001);
	   id.setProjId(101);
	   
	   domain=new ProgrammerProjectDetails();
	   domain.setId(id);
	   domain.setPrgmrName("Raja");
	   domain.setProjName("chari");
	   
	   //save object
	   try{
		 tx=ses.beginTransaction();
		   idVal=(PrgmrProjId)ses.save(domain);
		 tx.commit();
		 System.out.println("Object is saved");  
	   }//try
	   catch(Exception e){
		   tx.rollback();
		   e.printStackTrace();
	   }
	   System.out.println("Generated idValue::"+idVal);
	   //close objects
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	}//main
}//class
