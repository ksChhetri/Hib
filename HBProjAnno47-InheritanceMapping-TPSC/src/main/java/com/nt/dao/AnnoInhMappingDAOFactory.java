package com.nt.dao;

public class AnnoInhMappingDAOFactory {
	
	public static  AnnoInhMappingDAO getInstance(){
		return new AnnoInhMappingDAOImpl();
	}
}
