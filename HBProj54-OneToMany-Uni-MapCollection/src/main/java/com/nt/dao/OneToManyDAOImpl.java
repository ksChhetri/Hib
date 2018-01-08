package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		Map<String,PhoneNumber> map=null;
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
		map=new HashMap();
		map.put("FaGift",ph1);
		map.put("SpGift",ph2);
		//add childs to parent
		user.setPhones(map);
		
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
	
/*	@Override
	public void loadData() {
		Session ses=null;
		List<User> list=null;
		Map<String,PhoneNumber> childs=null;
		Set<String> keys=null;
		Query query=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//load Users
		query=ses.createQuery("from User");
		list=query.list();
		//process the results
		for(User user:list){
			System.out.println(user);
			childs=user.getPhones();
			 keys=(Set<String>) childs.keySet();
			 for(String key:keys){
				 System.out.println(key+"------>  "+childs.get(key));
			 }
			
			}//for 
	}//method 
	*/
	
	@Override
	public void deleteOnePhoneNumberOfAUser() {
		Session ses=null;
		Query query=null;
		User user=null;
		Map<String,PhoneNumber> childs=null;
		PhoneNumber ph=null;
		Transaction tx=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//Load parent object (User)
		user=ses.get(User.class,1006);
		//get childs of a parent
		childs=user.getPhones();
		//delete child from collection
		try{
			tx=ses.beginTransaction();
			  childs.remove("SpGift");
			tx.commit();
			System.out.println("Removing 1 child from collection of childs");
		}//try
		catch(Exception e){
			tx.rollback();
		}
}//method
	
}//class
