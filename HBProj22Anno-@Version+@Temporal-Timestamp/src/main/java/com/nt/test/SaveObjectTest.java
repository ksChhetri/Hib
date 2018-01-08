package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {
	
	public static void main(String[] args) {
		 Session ses=null;
		 Transaction tx=null;
		 Student st=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Domain class object
		//save object
		st=new Student();
		st.setSno(904);st.setSname("rajesh");st.setSadd("vizag");
		try{
		 tx=ses.beginTransaction();
		   ses.save(st);
		 tx.commit();
		 System.out.println("object saved--->ver::"+st.getVer()+"Date:"+st.getLastUpdated());
		}//try
		catch(Exception e){
			tx.rollback();
		}
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
