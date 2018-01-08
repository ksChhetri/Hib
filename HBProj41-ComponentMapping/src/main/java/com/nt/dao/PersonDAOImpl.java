package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.JobType;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {
	private static final String GET_PERSON_DETAILS="from Person";
	private static final String GET_PERSON_DETAILS_BY_DESG="from Person where pjob.desg=:role";

	@Override
	public void saveData() {
       Session ses=null;
       Person p1=null,p2=null;
       JobType jt1=null,jt2=null;
       Transaction tx=null;
		//get Session
       ses=HibernateUtil.getSession();
       //prepare objects
       jt1=new JobType();
       jt1.setDesg("programmer"); jt1.setDept("IT"); jt1.setSalary(90000);
       p1=new Person();
       p1.setPname("raja"); p1.setPjob(jt1);
       
       jt2=new JobType();
       jt2.setDesg("clerk"); jt2.setDept("Accounts"); jt2.setSalary(15000);
       p2=new Person();
       p2.setPname("ravi"); p2.setPjob(jt2);
       //save objects
       try{
    	   tx=ses.beginTransaction();
    	      ses.save(p1); ses.save(p2);
    	   tx.commit();
       }//try
       catch(Exception e){
    	   tx.rollback();
       }
	}//method
  @Override
public void loadAllData() {
	  Session ses=null;
	  Query query=null;
	  List<Person> list=null;
	  //get Session
	  ses=HibernateUtil.getSession();
	  //create Query object
	  query=ses.createQuery(GET_PERSON_DETAILS);
	  //execute query
	  list=query.list();
	  //process the result
	  System.out.println("All PErsons Info:::");
	  for(Person per:list){
		  System.out.println(per);
	  }
   }//method
  
  @Override
public void loadPersonDataByDesg(String desg) {
	  Session ses=null;
	  Query query=null;
	  List<Person> list=null;
	  //get Session
	  ses=HibernateUtil.getSession();
	  //create Query object
	  query=ses.createQuery(GET_PERSON_DETAILS_BY_DESG);
	  //set param values
	  query.setString("role",desg);
	  //execute query
	  list=query.list();
	  //process the result
	  System.out.println("All PErsons Info whose desg is :::"+desg);
	  for(Person per:list){
		  System.out.println(per);
	  }
  }//method
  
}//class
