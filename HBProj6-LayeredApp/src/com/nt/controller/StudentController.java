package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceFactory;
import com.nt.vo.StudentVO;

public class StudentController {
	
	public String processStudentInfo(String no,String sname,String m1,String m2,String m3)throws Exception{
		 StudentVO vo=null;
		 StudentDTO dto=null;
		 StudentService service=null;
		 String result=null;
		//prepare VO having inputs
		vo=new StudentVO();
		vo.setNo(no);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		//convert VO to DTO
		dto=new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getNo()));
		dto.setSname(sname);
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use Service class
		service=StudentServiceFactory.getInstance();
		result=service.generateResult(dto);
		return result;
	}//method

}//class

