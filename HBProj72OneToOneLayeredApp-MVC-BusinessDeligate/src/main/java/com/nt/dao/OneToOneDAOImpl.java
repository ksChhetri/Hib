package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {
    private static final String HQL_GET_All_STUDENTS_AND_LIBRARYDETAILS="from Student";
	
    @Override
	public List<Student> getAllStudentsAndTheirLibraryMembershipDetails() {
		Session ses=null;
		Query query=null;
		List<Student> listDomains=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery(HQL_GET_All_STUDENTS_AND_LIBRARYDETAILS);
		//execute the Query
		listDomains=query.list();
		return listDomains;
	}
    
    @Override
    public int insertStudentWithLibrary(Student student) {
    	Session ses=null;
    	Transaction tx=null;
    	int sid=0;
		//get Session
		ses=HibernateUtil.getSession();
		//save object
		try{
			tx=ses.beginTransaction();
			   sid=(Integer)ses.save(student);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
    	return sid;
    }//method

	@Override
	public int deleteStudentWithLibary(int no) {
		Session ses=null;
		Student  stud=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		//load the object
		stud=ses.get(Student.class,no);
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
		}
	}//method
}//class
