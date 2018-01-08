package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.cid.PrgmrProjId;
import com.nt.domain.ProgrammerProjectDetails;
import com.nt.utility.HibernateUtil;

public class CompositeIdSelectTest {

	public static void main(String[] args) {
	   Session ses=null;
	   ProgrammerProjectDetails domain=null;
	   PrgmrProjId id=null;
		//save object
	   ses=HibernateUtil.getSession();
	   
	   //prepare id class obj
	   id=new PrgmrProjId();
	   id.setPrgmrId(1001); id.setProjId(101);
	   
	   //Load object...
	   domain=ses.get(ProgrammerProjectDetails.class,id);
	   System.out.println(domain);
	   
	   //close objects
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	}//main
}//class
