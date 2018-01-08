package com.nt.dao;

public class AnnoOneToManyDAOFactory {
	
	public static  AnnoOneToManyDAO getInstance(){
		return new AnnoOneToManyDAOImpl();
	}
}
