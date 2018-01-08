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
	public void saveDataUsingUser() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		user=new User();
		user.setFirstName("rani");
	    
		ph1=new PhoneNumber();
		ph1.setNumberType("office"); ph1.setPhone(999999299l);
		ph2=new PhoneNumber();
		ph2.setNumberType("residence"); ph2.setPhone(88823888l);
		//add phoneNumber objects Set collection
		childs=new HashSet();
		childs.add(ph1); childs.add(ph2);
		//set childs to parent
		user.setPhones(childs);
		//set parent to childs
		ph1.setParent(user); ph2.setParent(user);

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

	@Override
	public void saveDataUsingPhoneNumber() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		user=new User();
		user.setFirstName("chari");
	    
		ph1=new PhoneNumber();
		ph1.setNumberType("office"); ph1.setPhone(4444424l);
		ph2=new PhoneNumber();
		ph2.setNumberType("residence"); ph2.setPhone(552555l);
		//add phoneNumber objects Set collection
		childs=new HashSet();
		childs.add(ph1); childs.add(ph2);
		//set childs to parent
		user.setPhones(childs);
		//set parent to childs
		ph1.setParent(user); ph2.setParent(user);

		//save objs (parent to childs)
		try{
			tx=ses.beginTransaction();
			  ses.save(ph1);
			  ses.save(ph2);
			tx.commit();
			  System.out.println("objects are saved");
		}//try
		catch(Exception e){
		   tx.rollback();
		}
	
	}
	

}//class
