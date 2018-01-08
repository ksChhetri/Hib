package com.nt.dao;

public interface OneToOneDAO {
	public void saveDataUsingStudent();
	public void saveDataUsingLibrary();
	public void loadDataUsingStudent(); 
	public void loadDataUsingLibrary();
	public void  removeDataUsingStudent();
	public void deleteOnlyLibraryMembeship();
}
