package com.nt.service;

public class StudentResultServiceFactory {
	
	public static StudentResultService getInstance(){
		return new StudentResultServiceImpl();
	}

}
