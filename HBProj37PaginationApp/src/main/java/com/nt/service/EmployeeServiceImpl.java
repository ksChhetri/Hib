package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.domain.EmployeeHLO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public long getReportPagesCount(int pageSize) {
		EmployeeDAO dao=null;
		long empsCount=0;
		long pagesCount=0;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//use DAO
		empsCount=dao.getEmployeesCount();
		if(empsCount%pageSize==0){
			pagesCount=empsCount/pageSize;
		}
		else{
			pagesCount=empsCount/pageSize;
			pagesCount++;
		}
		return pagesCount;
	}

	@Override
	public List<EmployeeDTO> getReportPageData(int pageNo, int pageSize) {
		int startPos=0;
		List<EmployeeHLO> listHLO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDAO dao=null;
		EmployeeDTO dto=null;
		//get start Position
		startPos=(pageNo*pageSize)-pageSize;
		//use DAO
		dao=EmployeeDAOFactory.getInstance();
		listHLO=dao.getEmployees(startPos,pageSize);
		//Convert ListHLO to ListDTO
		listDTO=new ArrayList();
		for(EmployeeHLO hlo:listHLO){
			dto=new EmployeeDTO();
			dto.setEid(hlo.getEid());
			dto.setFirstName(hlo.getFirstName());
			dto.setLastName(hlo.getLastName());
			dto.setEmail(hlo.getEmail());
			listDTO.add(dto);
		}//for
		
		return listDTO;
	}//method
}//class
