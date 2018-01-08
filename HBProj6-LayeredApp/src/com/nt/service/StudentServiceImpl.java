package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOFactory;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=null;
		int count=0; 
		StudentBO bo=null;
		//write b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//prepare BO having persitable data
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//get DAO
		dao=StudentDAOFactory.getInstance();
		//use DAO
		count=dao.insert(bo);
        if(count!=0)
        	return "Result="+result+" Registration Success";
        else
        	return "Result="+result+" Registration Failed";
	}//method
}//class
