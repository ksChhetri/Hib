package com.nt.dao;

import java.util.List;

import com.nt.domain.EmployeeHLO;

public interface EmployeeDAO {
	public  long getEmployeesCount();
	public List<EmployeeHLO> getEmployees(int startPos,int pageSize);

}
