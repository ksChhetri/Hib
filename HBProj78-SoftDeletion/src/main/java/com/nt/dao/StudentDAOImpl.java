package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int deleteStudentByNo(int sno) {
		Session ses=null;
		Transaction tx=null;
		Student stud=null;
		// get Session
		ses=HibernateUtil.getSession();
		//load object
		stud=ses.get(Student.class,sno);
		//delete the object
		try{
			tx=ses.beginTransaction();
			 ses.delete(stud);
			tx.commit();
			return 1;
		}
		catch(Exception e){
			tx.rollback();
			return 0;	
		}//catch
		
	}//method
	@Override
	public void loadAllStudents() {
		Session ses=null;
		Student stud=null;
		Query query=null;
		List<Student> list=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Student");
		//execute Query
		list=query.list();
		//process the ReusltSet
		list.forEach(st->{
			System.out.println(st);
		});
	}//method
}//class
