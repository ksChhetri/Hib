package com.nt.test;

import com.nt.dao.OneToOneDAO;

import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneTest {

	public static void main(String[] args) {
		OneToOneDAO dao=null;		
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		//save object
		//dao.saveDataUsingStudent();
		//dao.saveDataUsingLibrary();
		//dao.loadDataUsingStudent();
		//dao.loadDataUsingLibrary();
		//dao.removeDataUsingStudent();
		dao.deleteOnlyLibraryMembeship();
		
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
