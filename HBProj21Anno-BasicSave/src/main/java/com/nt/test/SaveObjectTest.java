package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Student stud=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create domain object
		stud=new Student();
		stud.setSno(1015);
		stud.setSname("ramesh");
		stud.setSadd("vizag");
		//save object
		try{
		 tx=ses.beginTransaction();
		  ses.save(stud);
		 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
		//close object
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
