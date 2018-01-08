package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.bo.StudentBO;
import com.nt.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {
  
	
	@Override
	public int insert(StudentBO bo) throws Exception {
		Session ses=null;
		Transaction tx=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		//save object
		try{
		 tx=ses.beginTransaction();	
		 idVal=(Integer) ses.save(bo);
		 tx.commit();
		 return idVal;
		}
		catch(Exception e){
			tx.rollback();
			throw e;
		}
	}//method

}
