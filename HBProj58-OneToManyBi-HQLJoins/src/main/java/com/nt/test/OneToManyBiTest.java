package com.nt.test;

import com.nt.dao.OneToManyBiDAO;
import com.nt.dao.OneToManyBiDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
		OneToManyBiDAO dao=null;
		  //get DAO
		dao=OneToManyBiDAOFactory.getInstance();
		//use DAO
		dao.loadDataUsingUserWithTheSupportOfHQLJoins();
		//dao.loadDataUsingPhoneNumberWithTheSupportOfHQLJoins();
		//dao.loadDataUsingUser();
		//dao.loadDataUsingUSerThroughQBC();
		  //close objs
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();
	}//main
}//class
