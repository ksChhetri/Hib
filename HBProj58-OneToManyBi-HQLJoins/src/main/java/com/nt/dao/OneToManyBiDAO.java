package com.nt.dao;

public interface OneToManyBiDAO {
	
	public  void   loadDataUsingUserWithTheSupportOfHQLJoins();
	public  void   loadDataUsingPhoneNumberWithTheSupportOfHQLJoins();
	public void loadDataUsingUser();
	public void loadDataUsingUSerThroughQBC();
	
}
