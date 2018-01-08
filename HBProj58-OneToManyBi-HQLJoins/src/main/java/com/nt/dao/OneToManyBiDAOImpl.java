package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void loadDataUsingUserWithTheSupportOfHQLJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare HQL Join Query  (parent to child)
		//query=ses.createQuery("select u.userId,u.first_name,ph.phone,ph.numberType from User u inner join u.phones ph");
		//query=ses.createQuery("select u.userId,u.first_name,ph.phone,ph.numberType from User u left join u.phones ph");
		//query=ses.createQuery("select u.userId,u.first_name,ph.phone,ph.numberType from User u right join u.phones ph");
		query=ses.createQuery("select u.userId,u.first_name,ph.phone,ph.numberType from User u full join u.phones ph");
		//execute HQL
		list=query.list();
		//process the result
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+" ");
			}//for
			System.out.println();
		}//for
		
	}//method
	
	@Override
	public void loadDataUsingPhoneNumberWithTheSupportOfHQLJoins() {
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("select u.userId,u.first_name,ph.phone,ph.numberType from PhoneNumber ph inner join ph.parent u ");
		//execute HQL
				list=query.list();
			list.forEach(row->{
				for(Object val:row){
					System.out.print(val+" ");
				}
				System.out.println();
			});	
				/*//process the result
				for(Object row[]:list){
					for(Object val:row){
						System.out.print(val+" ");
					}//for
					System.out.println();
				}//for
*/	}//method
	
	@Override
	public void loadDataUsingUser() {
		Session ses=null;
		
		List<User> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//query=ses.createQuery("select u from User u inner join fetch u.phones");
		query=ses.createQuery("from User ");
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
	public void loadDataUsingUSerThroughQBC() {
    	Session ses=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		Query query=null;
		Criteria criteria=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Criteria Object
		criteria=ses.createCriteria(User.class);
		criteria.setFetchMode("phones",FetchMode.JOIN);
		list=criteria.list();
		for(User user:list){
		System.out.println(user);
		childs=user.getPhones();
		 for(PhoneNumber ph:childs){
			 System.out.println(ph);
		 }//for
	  }//for
	}//method
	
}//class
