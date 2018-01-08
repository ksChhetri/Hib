package com.nt.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {
	@Override
	public void saveDataUsingStudent() {
		Student st=null;
		LibraryMembership lib=null;
		Session ses=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		st=new Student();
		st.setSname("raja");
		st.setSadd("hyd");
		
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		//set parent to child and child to parent
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		//save object (parent to child)
		try{
			tx=ses.beginTransaction();
			  ses.save(st);
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
	}//method
}//class
