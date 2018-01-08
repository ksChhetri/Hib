package com.nt.test;

import com.nt.dao.InheritanceMappingDAO;
import com.nt.dao.InheritanceMappingDAOFactory;
import com.nt.utility.HibernateUtil;

public class InheritanceMappingTest {

	public static void main(String[] args) {
		InheritanceMappingDAO dao=null;
		//get DAO
		dao=InheritanceMappingDAOFactory.getInstance();
		//use DAO
		//dao.saveData();
		dao.displayData();
		
		
		//close hibernate objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
