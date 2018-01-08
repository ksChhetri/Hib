package com.nt.service;

public class BankServiceFactory {
	public static BankService  getInstance(){
		return new BankServiceImpl();
	}

}
