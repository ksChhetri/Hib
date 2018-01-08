package com.nt.test;

import com.nt.dao.TransferEmployeeDAO;
import com.nt.dao.TransferEmployeeDAOFactory;
import com.nt.utility.MySqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TwoDBsTest {

	public static void main(String[] args) {
		TransferEmployeeDAO dao=null;
		//get DAO
		dao=TransferEmployeeDAOFactory.getInstance();
		System.out.println("Employee Transffered?"+dao.transfer(1001));
		
		//close objs
		OracleHibernateUtil.closeSession();
		MySqlHibernateUtil.closeSession();
		OracleHibernateUtil.closeSessionFactory();
		MySqlHibernateUtil.closeSessionFactory();
	}//main
}//class
