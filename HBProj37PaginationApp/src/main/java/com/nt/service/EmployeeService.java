package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	
	public  long getReportPagesCount(int pageSize);
	public  List<EmployeeDTO>  getReportPageData(int pagetNo,int pageSize);

}
