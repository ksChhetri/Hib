package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.HBStudentDTO;
import com.nt.service.StudentResultService;
import com.nt.service.StudentResultServiceFactory;
import com.nt.vo.HBStudentVO;

public class StudentResultControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=null,m1=null,m2=null,m3=null;
		HBStudentVO vo=null;
		HBStudentDTO dto=null;
		StudentResultService service=null;
		String result=null;
		RequestDispatcher rd=null;
		//read form data
		name=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//create VO class obj having inputs
		vo=new HBStudentVO();
		vo.setSname(name);vo.setM1(m1);vo.setM2(m2);vo.setM3(m3);
		//covnert VO class obj to DTO class object
		dto=new HBStudentDTO();
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//use Servie class
		service=StudentResultServiceFactory.getInstance();
		try{
		 
			result=service.generateResult(dto);	
		 //keep request in request scope
		 req.setAttribute("stResult",result);
		 //forward to jsp 
		 rd=req.getRequestDispatcher("/result.jsp");
		 rd.forward(req,res);
		}
		catch(Exception e){
		 rd=req.getRequestDispatcher("/err.jsp");
		 rd.forward(req,res);
		}
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
