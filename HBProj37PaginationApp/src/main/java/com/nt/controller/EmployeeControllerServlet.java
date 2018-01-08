package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.service.EmployeeServiceFactory;

public class EmployeeControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageSize=0;
		int pageNo=0;
		EmployeeService service=null;
		List<EmployeeDTO> listDTO=null;
		RequestDispatcher rd=null;
		long pagesCount=0;
		//read form data
		pageSize=Integer.parseInt(req.getParameter("pageSize"));
		if(req.getParameter("pageNo")==null || req.getParameter("pageNo").length()==0 )
			pageNo=1;
		else
		pageNo=Integer.parseInt(req.getParameter("pageNo"));
		//use Service class
		service=EmployeeServiceFactory.getInstance();
		//get Report data
		listDTO=service.getReportPageData(pageNo, pageSize);
		//get PagesCount
		pagesCount=service.getReportPagesCount(pageSize);
		//keep results in request scope
		req.setAttribute("reportData",listDTO);
		req.setAttribute("pagesCount", pagesCount);
		req.setAttribute("pageSize",pageSize);
		req.setAttribute("pageNo",pageNo);
		//forward to report.jsp
		rd=req.getRequestDispatcher("/report.jsp");
		rd.forward(req,res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class

