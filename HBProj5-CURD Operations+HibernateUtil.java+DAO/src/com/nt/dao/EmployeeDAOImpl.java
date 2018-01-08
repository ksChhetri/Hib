package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int registerEmployee(int no, String fname, String lname, String email) {
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		int id=0;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare Domain class object
		emp=new Employee();
		emp.setEid(no);emp.setFirstName(fname);
		emp.setLastName(lname); emp.setEmail(email);
		try{
         tx=ses.beginTransaction();
          id=(Integer)ses.save(emp);
         tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		return id;
	}//method

	@Override
	public void updateEmployee(int no, String newEmail) {
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object
		emp=ses.get(Employee.class,no);
		if(emp!=null){
		try{
		  tx=ses.beginTransaction();
		    emp.setEmail(newEmail);
		  tx.commit();
		  System.out.println("Record updated");
		  }
		 catch(Exception e){
			 tx.rollback();
			System.out.println("Record not updated");
		 }
		}//if
		else{
			System.out.println("record not found to update");
		}
	}//method

	@Override
	public void deleteEmployee(int no) {
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object
		emp=ses.get(Employee.class,no);
		if(emp!=null){
		try{
			tx=ses.beginTransaction();
			ses.delete(emp);
			tx.commit();
			System.out.println("Record deleted");
		  }//try
		catch(Exception e){
			tx.rollback();
			System.out.println("Record not deleted");
		  }
		}//if
		else{
			System.out.println("Record not found to delete");
		}
	}//method

	@Override
	public Employee getEmployeeById(int no) {
		Session ses=null;
		Employee emp=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load object
		emp=ses.get(Employee.class,no);
		return emp;
	}//method
}//class
