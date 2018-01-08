package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		//use DAO
		dao.saveData();
		//dao.loadData();
		//dao.deleteOnePhoneNumberOfAUser();
		//dao.deleteAllPhoneNumbersOfAUser();
		//dao.addNewPhoneNumberToExistingUser();
		//dao.movePhoneNumberFromOneUserToAnotherUser();
		
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
