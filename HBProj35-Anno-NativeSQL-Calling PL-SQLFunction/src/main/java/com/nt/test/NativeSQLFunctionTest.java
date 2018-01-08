package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class NativeSQLFunctionTest {

	public static void main(String[] args) {
		  Session ses=null;
		  Query query=null;
		  List<EmpDetails> list=null;
		  // get Session
		  ses=HibernateUtil.getSession();
		  //get Access Named Native SQL query 
		  query=ses.getNamedQuery("CALL_Fx");
		  //set values to Params
		  query.setInteger("min",100);
		  query.setInteger("max",200);
		  //excute Named Native SQL Query/calling PL/SQL Function
		  list=query.list();
		  //process the Reuslts
		  for(EmpDetails ed:list){
			  System.out.println(ed);
		  }
		  
		
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();

	}//main
}//class
