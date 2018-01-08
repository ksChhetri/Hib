package com.nt.test;

import com.nt.dao.AuthenitcationDAOFactory;
import com.nt.dao.AuthenticationDAO;
import com.nt.utility.HibernateUtil;

public class AuthenticateDAOTest {

	public static void main(String[] args) {
		AuthenticationDAO  dao=null;
		String result=null;
		//get DAO
		dao=AuthenitcationDAOFactory.getInstance();
		//use dAO
		result=dao.authenticate("raja","rani");
		System.out.println("Result=====>"+result);
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//method
}//class
