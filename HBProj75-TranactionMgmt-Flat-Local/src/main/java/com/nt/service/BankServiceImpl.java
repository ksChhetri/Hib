package com.nt.service;

import com.nt.dao.BankDAO;
import com.nt.dao.BankDAOFactory;

public class BankServiceImpl implements BankService {

	@Override
	public String transferFunds(int srcNo, int destNo, int amt) {
		BankDAO dao=null;
		int status=0;
		//get DAO
		dao=BankDAOFactory.getInstance();
		// use DAO
		status=dao.transferMoney(srcNo, destNo, amt);
		if(status==0)
		   return "Money not transfered";
		else
			return " Money transfered";
	}//method
}//class
