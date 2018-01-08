package com.nt.test;

import com.nt.dao.AnnoManyToOneDAO;
import com.nt.dao.AnnoManyToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class AnnoManyToOneTest {

	public static void main(String[] args) {
		AnnoManyToOneDAO dao=null;
		//get DAO
		dao=AnnoManyToOneDAOFactory.getInstance();
		//save data
		//dao.saveData();
		dao.loaData();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
