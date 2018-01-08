package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		 Session ses=null;
		 Query query=null;
		 List<EmpDetails> list=null;
		 List<Object[]> list1=null;
		 Transaction tx=null;
		 int count=0;
		  //get Session
		 ses=HibernateUtil.getSession();

		 /*//get Access to Named Native SQL Query
		 query=ses.getNamedQuery("GET_EMPs_BY_RANGE");
		 //set query param values
		 query.setInteger("min",100);
		 query.setInteger("max",200);
		 //execute Native SQL Query
		 list=query.list();
		 //process the reuslt
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }*/
		 
		/* //get Access to Named Native SQL Query
		 query=ses.getNamedQuery("GET_EMPs_BY_DOMAIN");
		 //set param values
		 query.setString("dmn","%yahoo.com");
		 //execute Query
		 list1=query.list();
		 //process the Result
		 for(Object row[]:list1){
			 for(Object val:row){
				 System.out.print(val+"  ");
			 }
			 System.out.println();
		 }*/
		 
		 //get Access to Named Native SQL query
		 query=ses.getNamedQuery("UPDATE_EMP_BY_NO");
		 //set param values
		 query.setString("newEmail","hello@hai.com");
		 query.setInteger("id",102);
		 //execute Query
		 try{
		  tx=ses.beginTransaction();
		   count=query.executeUpdate();
		  tx.commit();
		  System.out.println("no.of records effected::"+count);
		 }//try
		 catch(Exception se){
			 tx.rollback();
		 }
		 
		 
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();

	}//main
}//class
