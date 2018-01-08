package com.nt.test;

import com.nt.dao.HQLInsertDAO;
import com.nt.dao.HQLInsertDAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		HQLInsertDAO dao=null;
		int count=0;
		//get DAO
		dao=HQLInsertDAOFactory.getInstance();
		//use DAO
		count=dao.transferData("%hotmail.com");
		System.out.println("no.of records that are effected"+count);
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
