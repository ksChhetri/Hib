package com.nt.test;

import org.hibernate.Session;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class GetObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Student st=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//load object
		st=ses.get(Student.class,1001);
		System.out.println(st);
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
