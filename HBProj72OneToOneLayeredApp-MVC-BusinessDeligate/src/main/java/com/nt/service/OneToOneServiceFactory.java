package com.nt.service;

public class OneToOneServiceFactory {
	
	public static OneToOneService  getInstance(){
		return new OneToOneServiceImpl();
	}

}
