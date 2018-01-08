package com.nt.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.commons.DataRetrievingException;
import com.nt.commons.DeletionIssueException;
import com.nt.commons.StudentAlreadyRegisteredException;
import com.nt.delegate.OneToOneDelegate;
import com.nt.dto.StudentDTO;
import com.nt.vo.LibraryMembershipVO;
import com.nt.vo.StudentVO;

@WebServlet("/controller")
public class MainServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param=null;
		OneToOneDelegate delegate=null;
		List<StudentDTO> listDTO=null;
		RequestDispatcher rd=null;
		StudentVO stVO=null;
		LibraryMembershipVO libVO=null;
		String sname=null,sadd=null,doj=null;
		String result=null;
		String sno=null;
		//get BusinessDeligate object
		delegate=new OneToOneDelegate();
		//read Addtional request parameter (param) value
		param=req.getParameter("param");
		if(param.equals("link1")){
			try{
		    listDTO=delegate.getAllStudentsAndLibraryMembershipDetailsDelegate();
		    req.setAttribute("listDTO",listDTO);
		    rd=req.getRequestDispatcher("/show_details.jsp");
		    rd.forward(req,res);
			}
			catch(DataRetrievingException dre){
				req.setAttribute("errMsg",dre.getMessage());
				rd=req.getRequestDispatcher("/err.jsp");
				rd.forward(req,res);
			}//catch
		}//if
		else if(param.equals("register")){
			//read form data
			 sname=req.getParameter("sname");
			 sadd=req.getParameter("sadd");
			 doj=req.getParameter("doj");
			 //create StudentVO class having LibraryMembershipVO class object
			 libVO=new LibraryMembershipVO();
			 libVO.setDoj(doj);
			 stVO=new StudentVO();
			 stVO.setSname(sname);
			 stVO.setSadd(sadd);
			 stVO.setLibraryDetails(libVO);
			 libVO.setStudentDetails(stVO);
			 //use BusinessDelegate
			 try{
			    result=delegate.registerDelegate(stVO);
			   req.setAttribute("result",result);
			   
				 listDTO=delegate.getAllStudentsAndLibraryMembershipDetailsDelegate();
				    req.setAttribute("listDTO",listDTO);	 

			   rd=req.getRequestDispatcher("/show_details.jsp");
			    rd.forward(req,res);
			 }
			 catch(StudentAlreadyRegisteredException sare){
				   req.setAttribute("errMsg","Student AlreadyRegistrered??");
				 rd=req.getRequestDispatcher("/err.jsp");
				   rd.forward(req,res);
			 }
			 catch(ParseException pe){
				 req.setAttribute("errMsg","Date conversion problem");
				 rd=req.getRequestDispatcher("/err.jsp");
				   rd.forward(req,res);
			 }
			 catch(Exception e){
				 req.setAttribute("errMsg","Internal problem");
				 rd=req.getRequestDispatcher("/err.jsp");
				   rd.forward(req,res);
			 }
		}//else if
		else if(param.equals("link2")){
			//read student number
			sno=req.getParameter("sno");
			try{
			//use BusinessDeligate
			result=delegate.deleteStudentWithLibraryDelegate(sno);
			req.setAttribute("result",result);
			   
			 listDTO=delegate.getAllStudentsAndLibraryMembershipDetailsDelegate();
			    req.setAttribute("listDTO",listDTO);	 
               //forward request
		      rd=req.getRequestDispatcher("/show_details.jsp");
		      rd.forward(req,res);
			}//try
			catch(DeletionIssueException die){
				    req.setAttribute("errMsg","Student Not Deleted");
					 rd=req.getRequestDispatcher("/err.jsp");
					 rd.forward(req,res);
			}
			catch(DataRetrievingException dre){
				req.setAttribute("errMsg",dre.getMessage());
				rd=req.getRequestDispatcher("/err.jsp");
				rd.forward(req,res);
			}//catch
			catch(Exception e){
				req.setAttribute("errMsg","Internal problem");
				rd=req.getRequestDispatcher("/err.jsp");
				rd.forward(req,res);
			}//catch
			
		}
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)

}// class
