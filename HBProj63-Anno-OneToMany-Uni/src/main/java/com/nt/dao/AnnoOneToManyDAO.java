package com.nt.dao;

public interface AnnoOneToManyDAO {
	public void  saveData();
	public void loadData();
	public void loadDataUsingQBC();
	public void deleteOnePhoneNumberOfAUser();
	public void deleteAllPhoneNumbersOfAUser();

}
