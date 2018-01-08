package com.nt.test;

import com.nt.service.BankService;
import com.nt.service.BankServiceFactory;
import com.nt.utility.HibernateUtil;

public class TxMgmtTest {

	public static void main(String[] args) {
		BankService service=null;
		//get Service
		service=BankServiceFactory.getInstance();
		//use Service
		System.out.println(service.transferFunds(101, 103,500));
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
