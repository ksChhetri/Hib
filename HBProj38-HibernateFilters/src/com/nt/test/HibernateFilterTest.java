package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTest {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Query query=null;
		List<EmpDetails> list=null;
		List<Object> list1=null;
		Criteria criteria=null;
		SQLQuery query1=null;
		 // Get Session
		ses=HibernateUtil.getSession();
	/*	//Enable filter  for HQL
		filter=ses.enableFilter("FILTER_EMP_RANGE");
		//set Filter param  values
		filter.setParameter("min",100);
		filter.setParameter("max",200);
		//execute HQL Select Query
		query=ses.createQuery("from EmpDetails");
		//execute logics
		list=query.list();
		//process the results
		for(EmpDetails ed:list){
			System.out.println(ed);
		}
		//disable Filter
		ses.disableFilter("FILTER_EMP_RANGE");
		query=ses.createQuery("select count(*) from EmpDetails");
		list1=query.list();
		System.out.println("No.of Records:::"+list1.get(0));
	*/
	/*	//enable filter for QBC logic
		filter=ses.enableFilter("FILTER_EMP_RANGE");
		//set Filter param  values
		filter.setParameter("min",100);
		filter.setParameter("max",200);
		//execute QBC logic
		criteria=ses.createCriteria(EmpDetails.class);
		list=criteria.list();
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		
		//enable filter for Native SQL (not possible)
				filter=ses.enableFilter("FILTER_EMP_RANGE");
				//set Filter param  values
				filter.setParameter("min",100);
				filter.setParameter("max",200);
		    //execute Native SQL logic
				query1=ses.createSQLQuery("select * from Employee");
				query1.addEntity(EmpDetails.class);
				list=query1.list();
				for(EmpDetails ed:list){
					System.out.println(ed);
				}
		 
		
		
		//close Hibernate objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

	}

}
