package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class QBCTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		List<EmpDetails> list=null;
		Criterion cond1=null,cond2=null,cond3=null,andCond=null,finalCond=null;
		Order order=null;
		Projection p1=null,p2=null,p3=null;
		ProjectionList pList=null;
		List<Object[]> list1=null;
		
		
	   //get Session
		ses=HibernateUtil.getSession();
/*		//create Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//execute QBC
		list=criteria.list();
		//process the Result
		for(EmpDetails ed:list){
			System.out.println(ed);
		}
*/
		/* //execute QBC logic with one condition
		   //prepare Criteria object
		  criteria=ses.createCriteria(EmpDetails.class);
		  //prepare condition (Criterion object)
		  cond1=Restrictions.between("no",100, 200);
		  //add condition
		  criteria.add(cond1);
		  //execute QBC logic
		  list=criteria.list();
		  //process the result
		  for(EmpDetails ed:list){
			  System.out.println(ed);
		  }*/
		/* //execute QBC logic with two conditions
		   //prepare Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		 //prepare conditions
		cond1=Restrictions.like("mail","%gmail.com");
		cond2=Restrictions.ilike("fname","r%");
		//add conditions
		criteria.add(cond1); criteria.add(cond2);
		//execute logic
		list=criteria.list();
		//process the result
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		//execute QBC logic with  in clause conditions
		   //prepare Criteria object
		/*criteria=ses.createCriteria(EmpDetails.class);
		//prpeare condition
		cond1=Restrictions.in("lname","rao","chari");
		//add condition
		criteria.add(cond1);
		//execute QBC logic
		list=criteria.list();
		//process the result
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		/*//execute QBC logic with  and , or clause conditions
		   //prepare Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//prepare conditions
		cond1=Restrictions.ge("no",100);
		cond2=Restrictions.le("no",200);
		cond3=Restrictions.ne("lname","reddy");
		// add "and" clause on cond1,cond2
		andCond=Restrictions.and(cond1,cond2);
		//add or clause on "AndCond" and cond3
		finalCond=Restrictions.or(andCond,cond3);
		//add final condition
		criteria.add(finalCond);
		//excute logic
		list=criteria.list();
		//pross the result
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		
	/*	//Framing condition by using sql statement
		  //create Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//frame sql condition
		cond1=Restrictions.sqlRestriction(" email like '%gmail.com'");
		///add condition
		criteria.add(cond1);
		//execute logics
		list=criteria.list();
		//process the results
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		
	/*	//exampe on Order object
		criteria=ses.createCriteria(EmpDetails.class);
		///add condition
		cond1=Restrictions.between("no",100, 500);
		criteria.add(cond1);
		//add Order
		order=Order.desc("fname");
		criteria.addOrder(order);
		//execute logic
		list=criteria.list();
		//process the result
		for(EmpDetails ed:list){
			System.out.println(ed);
		}*/
		/*//Retriveing specific multiple col values using Projections.
		  //prepare Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//prepare projections
		p1=Projections.property("no");
		p2=Projections.property("mail");
		//add Projections to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1); pList.add(p2);
		//set ProjectionList to criteria object
		criteria.setProjection(pList);
		//prepare and add condition
		cond1=Restrictions.like("mail", "%123.com");
		criteria.add(cond1);
		//add Order
		order=Order.desc("mail");
		criteria.addOrder(order);
		//execute QBC logic
		list1=criteria.list();
		//process the result
		for(Object row[]:list1){
			  for(Object val:row){
				  System.out.print(val+"   ");
			  }//for
			System.out.println();
		}//for
*/		
	/*	//Retriveing specific single col value using Projections.
		  //prepare Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//Prepare Projection
		p1=Projections.property("mail");
		//add Projections to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1);
		//set ProjectionList to Criteria
		criteria.setProjection(pList);
		//execute logic
		List<String> list2=criteria.list();
		//process the result
		for(String mail:list2){
			System.out.println(mail+" ");
		}*/
		
/*		// Retrieving Aggragate results  
		   //prepare Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//prepare projection
		 p1=Projections.count("no");
		 //add Projection to Criteria
		 criteria.setProjection(p1);
		 //execute QBC logic
		 List<Integer> list3=criteria.list();
		 System.out.println("Employee Count::"+list3.get(0));
*/		 
		/*// Retrieving multiple Aggragate results  
		   //prepare Criteria object
		criteria=ses.createCriteria(EmpDetails.class);
		//prepare projection
		 p1=Projections.count("no");
		 p2=Projections.avg("no");
		 p3=Projections.min("no");
		 //add Projections to ProjectionList
		 pList=Projections.projectionList();
		 //add Projection to Criteria
		 pList.add(p1); pList.add(p2); pList.add(p3);
		 criteria.setProjection(pList);
		 //execute QBC logic
		 List<Object> list4=criteria.list();
         //process the result
		 Object row[]=(Object[])list4.get(0);
		 System.out.println("count :"+row[0]);
		 System.out.println("avg no col :"+row[1]);
		 System.out.println("min no col :"+row[2]);
		 */
		
		// For pagination
		 criteria=ses.createCriteria(EmpDetails.class);
		 //set params
		 criteria.setFirstResult(4);
		 criteria.setMaxResults(2);
		 //execute QBC logic
		 list=criteria.list();
		 //process the result
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
		 
		
		
		//close objects
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
