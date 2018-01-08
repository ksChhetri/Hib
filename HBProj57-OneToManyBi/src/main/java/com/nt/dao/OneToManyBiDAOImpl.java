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

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void saveDataUsingUser() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> set=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		user=new User();
		user.setUserId(1001); user.setFirst_name("raja"); 
		
		ph1=new PhoneNumber();
		ph1.setPhone(99999999L);
		ph1.setNumberType("office");
		
		ph2=new PhoneNumber();
		ph2.setPhone(8888888L);
		ph2.setNumberType("residence");
		//add pare to childs
		ph1.setParent(user); ph2.setParent(user);
		
		//add PhoneNumbers to Set Collection
		set=new HashSet();
		set.add(ph1);set.add(ph2);
		//add childs to parent
		user.setPhones(set);
		//save objects (parent ot child)
		try{
			tx=ses.beginTransaction();
			  ses.save(user);
			tx.commit();
			System.out.println("Objects are saved (parent to child)");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//mehtod
	
	@Override
	public void saveDataUsingPhoneNumber() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> set=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		user=new User();
		user.setUserId(1002); user.setFirst_name("ravi"); 
		
		ph1=new PhoneNumber();
		ph1.setPhone(7777777777L);
		ph1.setNumberType("office");
		
		ph2=new PhoneNumber();
		ph2.setPhone(66666666L);
		ph2.setNumberType("residence");
		//add pare to childs
		ph1.setParent(user); ph2.setParent(user);
		
		//add PhoneNumbers to Set Collection
		set=new HashSet();
		set.add(ph1);set.add(ph2);
		//add childs to parent
		user.setPhones(set);
		//save objects (child to parent)
		try{
			tx=ses.beginTransaction();
			  ses.save(ph1); ses.save(ph2);
			tx.commit();
			System.out.println("Objects are saved (parent to child)");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
	}//method
	
	@Override
	public void loadDataUsingUser() {
		Session ses=null;
		
		List<User> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from User");
		list=query.list();
        //use Java 8 forEach method
		list.forEach(user->{
			System.out.println(user);
			Set<PhoneNumber> childs=user.getPhones();
			//childs.forEach(ph->System.out.println(ph));
			//childs.forEach(System.out::println);
			childs.stream().forEach(System.out::println);
		});
		
		
		/*for(User user:list){
			System.out.println(user);
			childs=user.getPhones();
			 for(PhoneNumber ph:childs){
				 System.out.println(ph);
			 }
		}*/
		
	}//method
	
	@Override
	public void loadDataUsingPhoneNumber() {
       Session ses=null;
		List<PhoneNumber> list=null;
		Query query=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from PhoneNumber");
		list=query.list();
		
		//use Java 8 features
		list.forEach(ph->{
			System.out.println(ph);
			User user=ph.getParent();
			System.out.println(user);
		});
		
		/*for(PhoneNumber ph:list){
			System.out.println(ph);
			user=ph.getParent();
			 System.out.println(user);
		}*/
		
		
	}
	
}//class
