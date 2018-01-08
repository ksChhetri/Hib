package com.nt.test;

import com.nt.dao.AnnoInhMappingDAO;
import com.nt.dao.AnnoInhMappingDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoInhMappingTest {

	public static void main(String[] args) {
		AnnoInhMappingDAO dao=null;
	   // get DAO
		dao=AnnoInhMappingDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		dao.displayData();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
