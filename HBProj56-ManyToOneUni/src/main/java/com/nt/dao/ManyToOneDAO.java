package com.nt.dao;

public interface ManyToOneDAO {
	public  void  saveDataUsingEmpDetails();
	public void   loadDataUsingEmpDetails();
	public void  deleteOneChildOfAParent();
	public void  deleteParentAndItsAllChilds();
	public void deleteOnlyAllChildsOfAParent();

}
