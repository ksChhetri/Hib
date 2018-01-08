package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

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
		List<PhoneNumber> childs=null;
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
		childs=new ArrayList();
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
	

}//class
