package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.bo.HBStudent;
import com.nt.utility.HibernateUtil;

public class StudentResultDAOImpl implements StudentResultDAO {

	@Override
	public int insert(HBStudent student)throws Exception {
		Session ses=null;
		Transaction tx=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		//save object
		try{
		 tx=ses.beginTransaction();
		  idVal=(int)ses.save(student);
		 tx.commit();
		 return idVal;
		}
		catch(Exception e){
		 tx.rollback();
		 throw new Exception("Registration failed");
		}
	}//method

}//class
