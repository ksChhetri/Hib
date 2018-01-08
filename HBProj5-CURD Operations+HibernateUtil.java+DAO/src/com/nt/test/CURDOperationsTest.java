package com.nt.test;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class CURDOperationsTest {

	public static void main(String[] args) {
		EmployeeDAO dao=null;
		Employee emp=null;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//call methods
		//System.out.println("Emp registration:::"+dao.registerEmployee(3476,"raja","rao","rao@gmail.com"));
		emp=dao.getEmployeeById(3476);
		System.out.println("3456 emp details:::"+emp.getEid()+"  "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getEmail());
  	    //dao.updateEmployee(3456,"rao123@122.com");
		//dao.deleteEmployee(3456);
		
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
	}//method
}//class
