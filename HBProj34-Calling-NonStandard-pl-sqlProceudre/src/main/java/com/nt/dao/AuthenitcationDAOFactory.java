package com.nt.dao;

public class AuthenitcationDAOFactory {
	public  static AuthenticationDAO getInstance(){
		/*return new AuthenticationDAOImpl();*/
		return new AuthenticationDAOImpl1();
	}
}
