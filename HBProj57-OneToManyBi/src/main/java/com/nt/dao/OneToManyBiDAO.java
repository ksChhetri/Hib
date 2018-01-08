package com.nt.dao;

public interface OneToManyBiDAO {
	public  void saveDataUsingUser();
	public  void saveDataUsingPhoneNumber();
	public void loadDataUsingUser();
	public void loadDataUsingPhoneNumber();
}
