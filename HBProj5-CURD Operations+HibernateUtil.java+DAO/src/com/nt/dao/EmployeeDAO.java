package com.nt.dao;

import com.nt.domain.Employee;

public interface EmployeeDAO {
	public int registerEmployee(int no,String fname,String lname,String email);
	public void updateEmployee(int no,String newEmail);
	public void deleteEmployee(int no);
	public Employee getEmployeeById(int no);
}
