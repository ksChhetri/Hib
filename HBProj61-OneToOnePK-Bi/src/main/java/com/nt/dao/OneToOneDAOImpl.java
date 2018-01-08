package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {
	

	@Override
	public void saveDataUsingStudent() {
		Session ses=null;
		Student st1=null;
		LibraryMembership lib1=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		st1=new Student();
		st1.setSname("raja"); st1.setSadd("hyd");
		
		lib1=new LibraryMembership();
		lib1.setDoj(new Date());
		//set parent to child and child to parent
		st1.setLibraryDetails(lib1);
		lib1.setStudentDetails(st1);
		//save object
		try{
			tx=ses.beginTransaction();
			   ses.save(st1);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void saveDataUsingLibrary() {
		Session ses=null;
		Student st1=null;
		LibraryMembership lib1=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		st1=new Student();
		st1.setSname("ravi"); st1.setSadd("vizag");
		
		lib1=new LibraryMembership();
		lib1.setDoj(new Date());
		//set parent to child and child to parent
		st1.setLibraryDetails(lib1);
		lib1.setStudentDetails(st1);
		//save object
		try{
			tx=ses.beginTransaction();
			   ses.save(lib1);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		
	}//method
	
	@Override
	public void loadDataUsingStudent() {
		Session ses=null;
		List<Student> list=null;
		Query query=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Student");
		list=query.list();
		//process the List
		list.forEach(st->{
			System.out.println(st);
			LibraryMembership lib=st.getLibraryDetails();
			System.out.println(lib);
		});
	}//method
	
	@Override
	public void loadDataUsingLibrary() {
		Session ses=null;
		List<LibraryMembership> list=null;
		Criteria criteria=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		criteria=ses.createCriteria(LibraryMembership.class);
		criteria.setFetchMode("studentDetails",FetchMode.DEFAULT);
		list=criteria.list();
		//process the List
		list.forEach(lib->{
			System.out.println(lib);
			Student st=lib.getStudentDetails();
			System.out.println(st);
		});
		
	}//method
	
	@Override
	public void removeDataUsingStudent() {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load Student object
		st=ses.get(Student.class,1);
		//delete Student obj and its Associcated child object
		try{
			tx=ses.beginTransaction();
			   ses.delete(st);
			tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void deleteOnlyLibraryMembeship() {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		Query query=null;
		int result=0;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("delete from LibraryMembership where lid=:id");
		query.setInteger("id",2);
		try{
			tx=ses.beginTransaction();
			  result=query.executeUpdate();
			tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		System.out.println("No.of records effected::"+result);
	}//method

}//class
