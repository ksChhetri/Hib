package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class HQLTest {

	public static void main(String[] args) {
		   Session ses=null;
		   Query query=null;
		   List<EmpDetails> list=null;
		   List<Object[]> list1=null;
		   List<String> list2=null;
		   Iterator<EmpDetails> it=null;
		   Iterator<Object[]> it1=null;
		   EmpDetails details=null;
		   List<?> list3=null;
		   int result=0;
		   Transaction tx=null;
		   
		    // get Sesssion
		   ses=HibernateUtil.getSession();
		//create HQL Query
		   query=ses.createQuery("select ed from EmpDetails ed ");
		 //execute HQL Query
		   list=query.list();
		  //prcess the result
		  for(EmpDetails ed:list){
			  System.out.println(ed.getNo()+"  "+ed.getFname()+" "+ed.getLname()+" "+ed.getMail());
		  }//for
		 
	/*	   //create HQL select query with positional params
		   //query=ses.createQuery("from EmpDetails where no>=? and no<=?");
		 //create HQL select query with JPA style positional params
		   query=ses.createQuery("from EmpDetails where no>=?1 and no<=?2");
		   
		   //setting values to query  params
		   query.setInteger(1,100);
		   query.setInteger(2,200);

			  
		   //setting values to query jpa params
		   query.setInteger("1",100);
		   query.setInteger("2",200);
		   //execute the Query
		   list=query.list();
		 //prcess the result
			  for(EmpDetails ed:list){
				  System.out.println(ed.getNo()+"  "+ed.getFname()+" "+ed.getLname()+" "+ed.getMail());
			  }//for
		   */
		  /* //create HQL select query with named params
		   query=ses.createQuery("from EmpDetails where no>=:min and no<=:max");
		   //set values to query params
		   query.setInteger("min",100);
		   query.setInteger("max",200);
		   //execute the Query
		   list=query.list();
		   //process the result
		   for(EmpDetails ed:list){
			   System.out.println(ed);
		   }*/
		   
		 /*  //create HQL select query with positional, named params
		   query=ses.createQuery("from EmpDetails where no>=? and no<=:max");
		   //set values to query params
		   query.setInteger(0,100);
		   query.setInteger("max",200);
		   //execute the Query
		   list=query.list();
		   //process the result
		   for(EmpDetails ed:list){
			   System.out.println(ed);
		   }*/
		   
		   //create HQL Select Query that gives specific multiple col values*/
		/*   query=ses.createQuery("select no,mail from EmpDetails where mail like :domain");
		   //set param values
		   query.setString("domain","%gmail.com");
		   //execute the Query
		   list1=query.list();  //List Collection with Object class obj[]
		   //process the result
		   for(Object row[]:list1){
			   for(Object val:row){
				   System.out.print(val+" ");
			   }//for
			   System.out.println();
		   }//for
*/		   
		  /* //create HQL Query getting specific single column value
		   query=ses.createQuery("select mail from EmpDetails");
		   //execute HQL
		   list2=query.list();
		   //process the result
		   for(String mail:list2){
			   System.out.println(mail);
		   }
		   */
		/*   //create HQL select query that gives all col values of Db table
           query=ses.createQuery("from EmpDetails");
           //execute HQL
           it=query.iterate();
           //process the result
           int count=0;
           while(it.hasNext()){
              if(count==2)
               break;
        	  details=it.next();
        	  System.out.println(details);
        	  count++;
           }*/
           
		 /*  //create HQL select query that gives specific multiple col values of Db table
		   query=ses.createQuery("select fname,lname from EmpDetails");
           //execute HQL
           it1=query.iterate();
           while(it1.hasNext()){
        	   Object row[]=it1.next();
        	   for(Object val:row){
        		   System.out.print(val+"  ");
        	   }//for
        	   System.out.println();
           }//for
		   */
/*		   //create HQL select query performing aggragate operation
		   query=ses.createQuery("select max(no) from EmpDetails");
		   //execute query
		    list3=query.list();
		    System.out.println("records count::"+list3.get(0)+"  "+list3.get(0).getClass());
*/
        /*   //create HQL select query with sub query support
           query=ses.createQuery("from EmpDetails where no=(select max(no) from EmpDetails)");
           list=query.list();
           details=list.get(0);
           System.out.println(details);*/
		   
  /*  //create Non-select HQL Query
	    query=ses.createQuery("delete from EmpDetails where email like :domain"); 
	    query.setString("domain","%gmail.com");
	    try{
	     tx=ses.beginTransaction();
	       result=query.executeUpdate();
	     tx.commit();
	     if(result==0)
	    	 System.out.println("Record not deleted");
	     else
	    	 System.out.println(result+ " no.of Records are deleted");
	    }//try
	    catch(Exception se){
	    	tx.rollback();
	    }*/
    
		   
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();

	}//main
}//class
