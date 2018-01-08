package com.nt.dao;

public interface OneToManyDAO {
	public void saveData();
	public  void loadData();
	public void deleteOnePhoneNumberOfAUser();
	public void deleteAllPhoneNumbersOfAUser();
	public void addNewPhoneNumberToExistingUser();
	public void movePhoneNumberFromOneUserToAnotherUser();
}
