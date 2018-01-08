package com.nt.test;

import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOFactory;
import com.nt.utility.HibernateUtil;

public class SoftDeletionTest {

	public static void main(String[] args) {
		StudentDAO dao=null;
		int count=0;
	  //get DAO
		dao=StudentDAOFactory.getInstance();
		//invoke methods
		   /*count=dao.deleteStudentByNo(102);
		   if(count==0)
			   System.out.println("Record not deleted");
		   else
			   System.out.println("Record deleted");*/
		
		   dao.loadAllStudents();
		  
		   
		   //close Hibernate objects
		   HibernateUtil.closeSession();
		   HibernateUtil.closeSessionFactory();
	}//main
}//class
