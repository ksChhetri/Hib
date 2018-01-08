package com.nt.dao;

public class StudentResultDAOFactory {
	
	public static StudentResultDAO getInstance(){
		return new  StudentResultDAOImpl();
	}

}
