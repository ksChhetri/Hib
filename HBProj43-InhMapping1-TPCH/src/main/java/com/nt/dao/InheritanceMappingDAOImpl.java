package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Customer;
import com.nt.domain.Employee;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class InheritanceMappingDAOImpl implements InheritanceMappingDAO {
	private static final String GET_PERSONS="from Person";
	private static final String GET_EMPLOYEES="from Employee";
	private static final String GET_CUSTOMERS="from Customer";
	private static final String GET_DETAILS_BY_DISCRIMINATOR="SELECT * FROM IN_PERSONS WHERE PERSON_TYPE=:type";
	
	@Override
	public void saveData() {
		Session ses=null;
		Person per=null;
		Customer cust=null;
		Employee emp=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create Objects using the classes of inheritence hierarchy
		per=new Person();
		per.setName("raja"); per.setCompany("hcl");
		
		emp=new Employee();
		emp.setName("ravi");
		emp.setCompany("Wipro");
		emp.setDepartment(1001);
		emp.setSalary(90000);
		
		cust=new Customer();
		cust.setName("tarun"); cust.setCompany("IBM"); cust.setAddress("hyd");
		try{
		 tx=ses.beginTransaction();
		   ses.save(per); ses.save(emp); ses.save(cust);
		 tx.commit();
		 System.out.println("Objects are saved successfully... plese observe Db tables");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
@Override
	public void displayData() {
	Session ses=null;
	Query query1=null,query2=null,query3=null;
	List<Person> list1=null;
	List<Employee> list2=null;
	List<Customer> list3=null;
		//get Session 
	ses=HibernateUtil.getSession();
	//list persons
	query1=ses.createQuery(GET_PERSONS);
	list1=query1.list();
	for(Person per:list1){
		System.out.println(per);
	}
	System.out.println("-------------------------------------------------");
	//list Employees
	query2=ses.createQuery(GET_EMPLOYEES);
	list2=query2.list();
	for(Employee emp:list2){
		System.out.println(emp);
	}
	System.out.println("-------------------------------------------------");
	//list customers
	query3=ses.createQuery(GET_CUSTOMERS);
	list3=query3.list();
	for(Customer cust:list3){
		System.out.println(cust);
	}
	System.out.println("-------------------------------------------------");
	}//method

@Override
public void listData(String discrimininator) {
	Session ses=null;
	List<Person> list1=null;
	SQLQuery query=null;
	//get Session
	ses=HibernateUtil.getSession();
	//get Data
	query=ses.createSQLQuery(GET_DETAILS_BY_DISCRIMINATOR);
	query.setString("type", discrimininator);
	query.addEntity(Person.class);
	list1=query.list();
	for(Person per:list1){
		System.out.println(per);
	}
}//method

}//class
