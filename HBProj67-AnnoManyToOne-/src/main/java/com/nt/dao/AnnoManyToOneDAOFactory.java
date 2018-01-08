package com.nt.dao;

public class AnnoManyToOneDAOFactory {
	
	public static  AnnoManyToOneDAO  getInstance(){
		return new  AnnoManyToOneDAOImpl();
	}

}
