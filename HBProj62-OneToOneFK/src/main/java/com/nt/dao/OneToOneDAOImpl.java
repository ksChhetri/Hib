package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.License;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneFKDAO {

	@Override
	public void saveDataUsingLicense() {
		Session ses=null;
		Person per1=null,per2=null;
		License lic=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		per1=new Person();
		per1.setFirstName("raja"); per1.setLastName("rao"); per1.setAge((byte)40);
		per2=new Person();
		per2.setFirstName("ravi"); per2.setLastName("chari"); per2.setAge((byte)40);
		
		lic=new License();
		lic.setType("two-wheeler");
		lic.setValidFrom(new Date());
		lic.setValidTo(new Date(2027,10,20));
		//set parent to child
		lic.setLicenseHolder(per1);
		
		try{
			tx=ses.beginTransaction();
			   ses.save(lic);
			   ses.save(per2);
			tx.commit();
			System.out.println("Objects are saved.....");
		}//try
		catch(Exception e){
			tx.rollback();
		}//catch
	}//method
	
	@Override
	public void loadDataUsingLicense() {
		Session ses=null;
		List<License> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from License");
		//execute Query
		list=query.list();
		//process the List
		list.forEach(lic->{
			System.out.println(lic);
			Person per=lic.getLicenseHolder();
			System.out.println(per);
		});
	}//method
	
	@Override
	public void deleteOnlyLicense() {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int result=0;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("delete from License  where lid=:id");
		query.setInteger("id",1000);
		//execute the  Query
		try{
			tx=ses.beginTransaction();
			  result=query.executeUpdate();
			tx.commit();
			System.out.println("Record deleted");
		}
		catch(Exception e){
			tx.rollback();
		}
	}//method
}//class
