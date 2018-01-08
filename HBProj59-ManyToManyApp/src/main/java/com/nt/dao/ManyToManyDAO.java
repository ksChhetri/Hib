package com.nt.dao;

public interface ManyToManyDAO {
	public  void saveDataUsingProgrammer();
	public void  saveDataUsingProject();
	public  void  listDataUsingProgrammer();
	public  void listDataUsingProject();
	public void  addExistingProgrammerToExistingProject();
	public  void moveExistingProgrammerToExistingProject();
	
}
