package com.nt.dao;

public class InheritanceMappingDAOFactory {
	public static InheritanceMappingDAO getInstance(){
		return new InheritanceMappingDAOImpl();
	}

}
