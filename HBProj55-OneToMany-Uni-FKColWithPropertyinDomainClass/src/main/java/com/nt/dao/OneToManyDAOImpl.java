package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> set=null;
		Transaction tx=null; 
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare parent object
		user=new User();
		user.setUserId(1006);
		user.setFirstName("chari");
		//prepare child objects
		ph1=new PhoneNumber();
		ph1.setPhone(12929229l);
		ph1.setNumberType("office");
		
		ph2=new PhoneNumber();
		ph2.setPhone(128822822l);
		ph2.setNumberType("residence");
		//add child objs to Set collection
		set=new HashSet();
		set.add(ph1);set.add(ph2);
		//add childs to parent
		user.setPhones(set);
		
		//save objects
		try{
			tx=ses.beginTransaction();
			    ses.save(user);
			tx.commit();
		  System.out.println("Objects are saved");	
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	
	@Override
	public void loadData() {
		Session ses=null;
		List<User> list=null;
		Set<PhoneNumber> set=null;
		Query query=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//load Users
		query=ses.createQuery("from User");
		list=query.list();
		//process the results
		for(User user:list){
			System.out.println(user);
			set=user.getPhones();
			set.size();
			for(PhoneNumber ph:set){
				System.out.println(ph);
			}//for

			}//for 
	}//method
	
	@Override
	public void deleteOnePhoneNumberOfAUser() {
		Session ses=null;
		Query query=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//Load parent object (User)
		user=ses.get(User.class,1001);
		//get childs of a parent
		childs=user.getPhones();
		//load PhoneNumber object
		ph=ses.get(PhoneNumber.class,888888888L);
		//delete child from collection
		try{
			tx=ses.beginTransaction();
			  childs.remove(ph);
			tx.commit();
			System.out.println("Removing 1 child from collection of childs");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
	}//method
	
	@Override
	public void deleteAllPhoneNumbersOfAUser() {
		Session ses=null;
		Query query=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session 
		ses=HibernateUtil.getSession();
		// load parent object
		user=ses.get(User.class,1001);
		//load all child objs of a parent
		childs=user.getPhones();
		//delete all childs of a parent
		try{
			tx=ses.beginTransaction();
			  childs.removeAll(childs);
			 tx.commit();
			 System.out.println("all childs of parent are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void addNewPhoneNumberToExistingUser() {
		Session ses=null;
		Query query=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session 
		ses=HibernateUtil.getSession();
		// load parent object
		user=ses.get(User.class,1001);
		//get all chids of a parent
		childs=user.getPhones();
		//create new Child 
		ph=new PhoneNumber();
		ph.setPhone(777777777);
		ph.setNumberType("night calls");
		//add new child to existing childs
		try{
			tx=ses.beginTransaction();
			   childs.add(ph);
			tx.commit();
			System.out.println("new JIO number is added ");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void movePhoneNumberFromOneUserToAnotherUser() {
		Session ses=null;
		User srcUser=null,destUser;
		Set<PhoneNumber> srcUserChilds=null;
		Set<PhoneNumber> destUserChilds=null;
		PhoneNumber ph1=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		//Load Source User (1001)
		srcUser=ses.get(User.class,1001);
		//load all childs of 1001 user
		srcUserChilds=srcUser.getPhones();
		//Load 1001 User PhoneNumber that u want to delete
		ph1=ses.get(PhoneNumber.class,777777777L);
		
		//Load Dest user 1002
		destUser=ses.get(User.class,1002);
		//get All PhoneNumber of dest user 1002
		destUserChilds=destUser.getPhones();
		try{
			tx=ses.beginTransaction();
			   //delete phoneNuber src user
			   srcUserChilds.remove(ph1);
			tx.commit();
			System.out.println("PhoneNumber is deleted from 1001 user");
		}//try
		catch(Exception e){
			tx.rollback();
		}//catch
		
		try{
			tx=ses.beginTransaction();
			   //add  phoneNuber to dest  user
			   destUserChilds.add(ph1);
			tx.commit();
			System.out.println("PhoneNumber is added to 1002 user");
		}//try
		catch(Exception e){
			tx.rollback();
		}//catch
		
	}//method
}//class
