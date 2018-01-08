package com.nt.test;

import org.hibernate.Session;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {
		Session ses=null;
		Employee emp=null;
	   //get Session 
		ses=HibernateUtil.getSession();
		//load object
		emp=ses.get(Employee.class,(long)1234);
		System.out.println(emp.getEid()+"  "+emp.getFirstname()+"  "+emp.getLastname());
		//close hibernate objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
