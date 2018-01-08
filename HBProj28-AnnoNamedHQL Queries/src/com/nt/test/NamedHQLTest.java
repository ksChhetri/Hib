package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		   Session ses=null;
		   Query query=null;
		   List<EmpDetails> list=null;
		   Transaction tx=null;
		   int result=0;
		  // get Sesssion
		  ses=HibernateUtil.getSession();
		
		  //get Access to Named HQL Query
		  query=ses.getNamedQuery("GET_EMPS_By_DOMAIN");
		  //set values to query params
		  query.setString("dmn","%hotmail.com");
		  //execute Query
		  list=query.list();
		  //process the Result
		  for(EmpDetails details:list){
			  System.out.println(details);
		  }
		  
	
		  //get Access to Named HQL Query
		  query=ses.getNamedQuery("DELETE_EMPS");
		  //set param value
		  query.setString("surname","rao");
		  try{
		   tx=ses.beginTransaction();
		    result=query.executeUpdate();
		   tx.commit();
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
		  System.out.println("no.of records that are effeced::"+result);
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();
	}//main
}//class
