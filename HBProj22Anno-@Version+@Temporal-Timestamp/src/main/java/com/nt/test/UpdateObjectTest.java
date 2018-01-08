package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest {
	
	public static void main(String[] args) {
		 Session ses=null;
		 Transaction tx=null;
		 Student st=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object
		st=ses.get(Student.class,904);
		//update object
		try{
		 tx=ses.beginTransaction();
		   st.setSadd("mumbai5");
		   ses.update(st);
		 tx.commit();
		 System.out.println("object is updated--->ver::"+st.getVer()+"on date"+st.getLastUpdated());
		}//try
		catch(Exception e){
			tx.rollback();
		}
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
