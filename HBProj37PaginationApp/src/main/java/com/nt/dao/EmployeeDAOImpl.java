package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.domain.EmployeeHLO;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
 
	@Override
	public long getEmployeesCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection rowCount=null;
		long empsCount=0;
		List<Object> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Use QBC with Projection to get Employee count
		criteria=ses.createCriteria(EmployeeHLO.class);
		rowCount=Projections.rowCount();
		criteria.setProjection(rowCount);
		list=criteria.list();
		System.out.println(list.get(0).getClass());
		empsCount=(long) list.get(0);
		return empsCount;
	}//method

	@Override
	public List<EmployeeHLO> getEmployees(int startPos,int pageSize) {
		Session ses=null;
		Criteria criteria=null;
		List<EmployeeHLO> listHLO=null;
		   //get Session
		ses=HibernateUtil.getSession();
		//use QBC to get List of Employee  records
		criteria=ses.createCriteria(EmployeeHLO.class);
		//set pagination param values
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		//execute QBC logic
		listHLO=criteria.list();
		return listHLO;
	}//method
}//class
