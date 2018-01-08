package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Department;
import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class AnnoManyToOneDAOImpl implements AnnoManyToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Department dept=null;
		EmpDetails emp=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		dept=new Department();
		dept.setDeptName("Accounts"); dept.setDeptHead("SMITH");
		
		emp=new EmpDetails();
		emp.setEname("raja"); emp.setSalary(50000);
		//set parent to child
		emp.setDept(dept);
		//save object
		try{
			tx=ses.beginTransaction();
			  ses.save(emp);
			tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void loaData() {
		Session ses=null;
		Transaction tx=null;
		Query query=null;
		List<EmpDetails> list=null;
		//get Session
		ses=HibernateUtil.getSession();
	    //create Query
		query=ses.createQuery("from EmpDetails");
		list=query.list();
		/*//process result
		list.forEach(emp->{
         System.out.println(emp);
         Department dept=emp.getDept();
         System.out.println(dept);
		});*/
	}//method
}//class
