package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Department;
import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveDataUsingEmpDetails() {
		 Session ses=null;
		 Transaction tx=null;
		 Department dept=null;
		 EmpDetails details=null,details1=null;
		 //get Session
		 ses=HibernateUtil.getSession();
		 //prepare domain class objects
		   dept=new Department();
		   dept.setDeptno(1001);
		   dept.setDeptname("Accounts");
		   dept.setDepthead("Sony Agrawala");
		   
		   details=new EmpDetails();
		   details.setEno(101); details.setEname("raja"); details.setJob("CLERK");
		   
		   details1=new EmpDetails();
		   details1.setEno(102); details1.setEname("rajesh"); details1.setJob("MANAGER");
		   //map childs to parent
		   details.setDept(dept); details1.setDept(dept);
		   try{
			   tx=ses.beginTransaction();
			      ses.save(details);
			      ses.save(details1);
			   tx.commit();
			   System.out.println("Objects are saved...");
		   }//try
		   catch(Exception e){
			   tx.rollback();
		   }
	}//method
	
	@Override
	public void loadDataUsingEmpDetails() {
		 Session ses=null;
		 Query query=null;
		 List<EmpDetails> list=null;
		 Department dept=null;
		 //get Session
		 ses=HibernateUtil.getSession();
		 //prepare Query
		 query=ses.createQuery("from EmpDetails");
		 list=query.list();
		 //process the result
		 for(EmpDetails details:list){
			    System.out.println(details);
			    dept=details.getDept();
			    System.out.println(dept);
		 }
	}//method
	
	
	@Override
	public void deleteOneChildOfAParent() {
		/*  Bad Pratice...
		  Session ses=null;
		 EmpDetails details=null;
		 Transaction tx=null;
		 //get Session
		 ses=HibernateUtil.getSession();
		 //load the child that u want to delete
		 details=ses.get(EmpDetails.class,101);
		 //delete the child 
		 try{
			 tx=ses.beginTransaction();
			    ses.delete(details);
			 tx.commit();
			 System.out.println("Object child of a Parent is deleted");
		 }//try
		 catch(Exception e){
			 e.printStackTrace();
			 tx.rollback();
		 }*/
		  Session ses=null;
		  Query query=null;
		  int result=0;
		  Transaction tx=null;
		  //get Session
		  ses=HibernateUtil.getSession();
		  //prepare HQL Delete query
		  query=ses.createQuery("delete from EmpDetails where eno=:id");
		  query.setInteger("id",102);
		  try{
			  tx=ses.beginTransaction();
			     result=query.executeUpdate();
			  tx.commit();
			  System.out.println(result+"  no.of records are deleted");
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
	}//method
	
	@Override
	public void deleteParentAndItsAllChilds() {
		  Session ses=null;
		  Query query=null;
		  int result=0;
		  Transaction tx=null;
		  List<EmpDetails> list=null;
		  //get Session
		  ses=HibernateUtil.getSession();
		  //prepare HQL query to load all childs and their parents
		  query=ses.createQuery("from EmpDetails ");
		  list=query.list();
		  try{
			  tx=ses.beginTransaction();
			   for(EmpDetails ed:list){
				   ses.delete(ed);
			   }
			  tx.commit();
			  System.out.println("All childs and their parents are deleted");
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
	}//method
	
	@Override
	public void deleteOnlyAllChildsOfAParent() {
		 Session ses=null;
		  Query query=null;
		  int result=0;
		  Transaction tx=null;
		  //get Session
		  ses=HibernateUtil.getSession();
		  //prepare Delete query
		  query=ses.createQuery("delete from EmpDetails");
		  try{
			  tx=ses.beginTransaction();
			    result=query.executeUpdate();
			   tx.commit();
			   System.out.println(result+" no.of records are deleted");
		  }//try
		  catch(Exception e){
			  tx.rollback();
		  }
	}//method
	
	
}//class
