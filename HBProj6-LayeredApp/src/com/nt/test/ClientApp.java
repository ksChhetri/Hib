package com.nt.test;

import com.nt.controller.StudentController;
import com.nt.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		StudentController controller=null;
		String result=null;
		//create Controller
		controller=new StudentController();
		try{
		 result=controller.processStudentInfo("102","raja","56", "67","78");
		 System.out.println(result);
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
