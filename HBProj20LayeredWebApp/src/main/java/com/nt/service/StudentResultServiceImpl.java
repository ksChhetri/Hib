package com.nt.service;

import com.nt.bo.HBStudent;
import com.nt.dao.StudentResultDAO;
import com.nt.dao.StudentResultDAOFactory;
import com.nt.dto.HBStudentDTO;

public class StudentResultServiceImpl implements StudentResultService {

	@Override
	public String generateResult(HBStudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		HBStudent student=null;
		StudentResultDAO dao=null;
		int id=0;
         //write b.logic
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//prepare Domain/BO class object
		student=new HBStudent();
		student.setSname(dto.getSname());
		student.setTotal(total);
		student.setAvg(avg);
		student.setResult(result);
		//use DAO
		dao=StudentResultDAOFactory.getInstance();
		id=dao.insert(student);
		
		return "Student is registered with id::"+id;
	}//generateResult(-)
}//class
