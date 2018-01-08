package com.nt.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class NativeSQLTest {

	public static void main(String[] args) {
		 Session ses=null;
		 SQLQuery query=null;
		 List<Object[]>  list1=null;
		 List<EmpDetails> list2=null;
		 List<Object[]> list3=null;
		 List<Integer> list4=null;
		 int count=0;
		 Transaction tx=null;
		
		
		//get Session
		 ses=HibernateUtil.getSession();
		/* //prepare Native SQL Query
		 query=ses.createSQLQuery("select * from Employee");
		 //execute Query
		 list1=query.list();
		 //process the result
		 for(Object row[]:list1){
			 for(Object val:row){
				 System.out.print(val+" ");
			 }//for
			 System.out.println();
		 }//for
*/		
	/*	//prepare Native SQL Query (mapping domain class)
		 query=ses.createSQLQuery("select * from Employee where email like :dmn");
		 //set param values
		 query.setString("dmn","%gmail.com");
		 //map query results with domain classes
		 query.addEntity(EmpDetails.class);
		 //execute Query
		 list2=query.list();
		 //process the result
		 for(EmpDetails ed:list2){
			 System.out.println(ed);
		 }*/
    /* // prepare Native SQL Query(scalar) (getting specific multiple col values)
      query=ses.createSQLQuery("select eid,email from Employee where eid>=:start and eid<=:end");
      //set param values
      query.setInteger("start",100);
      query.setInteger("end",200);
      //map hibenrate data types for columns
      query.addScalar("eid",StandardBasicTypes.INTEGER);
      query.addScalar("email",StandardBasicTypes.STRING);
      
      //execute Query
      list3=query.list();
      //process the result
      for(Object row[]:list3){
    	  for(Object val:row){
    		  System.out.print(val+"   "+val.getClass());
    	  }//for
    	  System.out.println();
      }//for
      */
	 /* //prepare Native SQL query (scalar) having aggragate function
		query=ses.createSQLQuery("select count(*) from Employee");
		//map with Hibernate Data types
		query.addScalar("count(*)",StandardBasicTypes.INTEGER);
	  //execute query
		list4=query.list();
		count=list4.get(0);
		//get the result
		System.out.println("Records count::"+count);*/
		 
	 //prepare NativeSQL Non-select Query
		query=ses.createSQLQuery("insert into Employee values(:val1,:val2,:val3,:val4)");
		//set param values
	  query.setInteger("val1",1001);
	  query.setString("val2","raja");
	  query.setString("val3","rao");
	  query.setString("val4","raja@yahoo.com");
	  try{
	   tx=ses.beginTransaction();
	     count=query.executeUpdate();
	   tx.commit();
	  }//try
	  catch(Exception e){
		 tx.rollback();
	  }
	  System.out.println("no.of records effected::"+count);
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();

	}//main
}//class
