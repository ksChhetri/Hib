package com.nt.test;

import com.nt.dao.PersonDAO;
import com.nt.dao.PersonDAOFactory;
import com.nt.utility.HibernateUtil;

public class ComponetMappingTest {

	public static void main(String[] args) {
		PersonDAO dao=null;
		//get DAO
		dao=PersonDAOFactory.getInstance();
		//use DAO
		//dao.saveData();
		dao.loadAllData();
		dao.loadPersonDataByDesg("clerk");
		
		//close Session,SessionFactory
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
