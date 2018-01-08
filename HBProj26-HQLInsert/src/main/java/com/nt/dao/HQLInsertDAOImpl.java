package com.nt.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class HQLInsertDAOImpl implements HQLInsertDAO {
 private static final  String HQL_INSERT="INSERT INTO NGOMember(no,fname,lname,mail) select no,fname,lname,mail from EmpDetails where mail like :domain";  
	@Override
	public int transferData(String dmn) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int result=0;
		//get Session
		ses=HibernateUtil.getSession();
		//create Query object
		query=ses.createQuery(HQL_INSERT);
		//set param values
		query.setString("domain",dmn);
		//execute Query
		try{
		 tx=ses.beginTransaction();
		  result=query.executeUpdate();
		 tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		return result;
	}//method
}//class
