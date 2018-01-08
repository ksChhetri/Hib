package com.nt.test;

import com.nt.dao.AnnoOneToManyDAO;
import com.nt.dao.AnnoOneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoOneToManyTest {
	 public static void main(String[] args) {
		  AnnoOneToManyDAO dao=null;
		  //get DAO
		  dao=AnnoOneToManyDAOFactory.getInstance();
		  //use dAO
		  //dao.saveData();
		  
		  //close objects
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();
	}//main
}//class
