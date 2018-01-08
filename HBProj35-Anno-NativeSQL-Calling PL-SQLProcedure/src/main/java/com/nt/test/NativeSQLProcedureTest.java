package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class NativeSQLProcedureTest {

	public static void main(String[] args) {
		  Session ses=null;
		  Query query=null;
		  List<Object[]> list=null;
		  // get Session
		  ses=HibernateUtil.getSession();
		  //get Access Named Native SQL query 
		  query=ses.getNamedQuery("CALL_PROCEDURE");
		  //set values to Params
		  /*query.setString(0,"%hotmail.com");*/
		  query.setString("dmn","%gmail.com");
		  //excute Named Native SQL Query/calling PL/SQL Function
		  list=query.list();
		  //process the Reuslts
		  for(Object row[]:list){
			  for(Object val:row){
				  System.out.print(val+" ");
			  }
			  System.out.println();
		  }
		  
		
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();

	}//main
}//class
