package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class AnnoOneToManyDAOImpl implements AnnoOneToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		user=new User();
		user.setFirstName("raja");
	    
		ph1=new PhoneNumber();
		ph1.setNumberType("office"); ph1.setPhone(999999999l);
		ph2=new PhoneNumber();
		ph2.setNumberType("residence"); ph2.setPhone(8888888l);
		//add phoneNumber objects Set collection
		childs=new HashSet();
		childs.add(ph1); childs.add(ph2);
		//set chils to parent
		user.setPhones(childs);
		//save objs (parent to childs)
		try{
			tx=ses.beginTransaction();
			  ses.save(user);
			
			tx.commit();
			  System.out.println("objects are saved");
		}//try
		catch(Exception e){
		   tx.rollback();
		}
	}//method
	
	public void loadData(){
		Session ses=null;
		Query query=null;
		List<User> list=null;
		Set<PhoneNumber> set=null;
		//get Sessions
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from User");
		//execute Query
		list=query.list();
		//process the List
		for(User user:list){
			System.out.println(user);
			set=user.getPhones();
			for(PhoneNumber ph:set){
				System.out.println(ph);
			}//for
		}//for
	}//method
	
	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		
		Criteria criteria=null;
		//get Sessions
		ses=HibernateUtil.getSession();
		//create Criteria
		criteria=ses.createCriteria(User.class);
		//execute QBC
		list=criteria.list();
		list.forEach(user->{
			System.out.println(user);
			Set<PhoneNumber> set=user.getPhones();
			set.forEach(ph->{
				System.out.println(ph);
			});
		});
	}//mehtod
	
	@Override
	public void deleteOnePhoneNumberOfAUser() {
		Session ses=null;
		Query query=null;
		User user=null;
		PhoneNumber ph=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		
		//get Sessions
		ses=HibernateUtil.getSession();
		//Load parent object
		user=ses.get(User.class,2);
		//get childs of Parent 
		childs=user.getPhones();
		//load the child that u want to delete
		ph=ses.get(PhoneNumber.class,8888888l);
		//delete the above child from collection of chids
		try{
			tx=ses.beginTransaction();
			  childs.remove(ph);
			tx.commit();
			System.out.println("One child from collection of childs is deleted");
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
		PhoneNumber ph=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		
		//get Sessions
		ses=HibernateUtil.getSession();
		//load parent
		user=ses.get(User.class, 1);
		//load childs of parent
		childs=user.getPhones();
		// Remove All childs
		try{
		 tx=ses.beginTransaction();
			childs.remove(childs);
		 tx.commit();
		 System.out.println("All childs are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method

}//class
