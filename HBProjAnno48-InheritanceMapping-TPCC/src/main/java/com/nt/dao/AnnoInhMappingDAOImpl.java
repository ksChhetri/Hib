package com.nt.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.CashPayment;
import com.nt.domain.ChequePayment;
import com.nt.domain.CreditCardPayment;
import com.nt.domain.Payment;
import com.nt.utility.HibernateUtil;

public class AnnoInhMappingDAOImpl implements AnnoInhMappingDAO {

	@Override
	public void saveData() {
		Session ses=null;
		CreditCardPayment ccPayment=null;
		ChequePayment chPayment=null;
		CashPayment cashPayment=null;
		Transaction tx=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Domain class objects
		ccPayment=new CreditCardPayment();
		ccPayment.setAmount(20000); ccPayment.setCardNo(123455); ccPayment.setCcType("VISA");
		
		chPayment=new ChequePayment();
		chPayment.setAmount(30000); chPayment.setChequeNo(1234);chPayment.setChequeType("SELF");
		
		 cashPayment=new CashPayment();
		 cashPayment.setAmount(900000); cashPayment.setDenominations("2000*45");
		 //save objects
		 try{
			 tx=ses.beginTransaction();
			     ses.save(ccPayment);
			     ses.save(chPayment);
			     ses.save(cashPayment);
			     tx.commit();
			     System.out.println("Objects are saved");
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
	}//method
	
	@Override
	public void displayData() {
		Session ses=null;
		List<Payment> listPayment=null;
		List<CreditCardPayment> listCredit=null;
		List<ChequePayment> listCheque=null;
		List<CashPayment> listCash=null;
		Query query1=null,query2=null,query3=null,query4=null;
		//get Seesion 
		ses=HibernateUtil.getSession();
		//using Payment
		query1=ses.createQuery("from Payment");
		listPayment=query1.list();
		for(Payment payment:listPayment){
			System.out.println(payment);
		}
   System.out.println("-------------------------------------------");		
		//using CreditCardPayment
		query2=ses.createQuery("from CreditCardPayment");
		listCredit=query2.list();
		for(CreditCardPayment payment:listCredit){
			System.out.println(payment);
		}
		System.out.println("-------------------------------------------");		
		//using ChequePayment 
		query3=ses.createQuery("from ChequePayment");
		listCheque=query3.list();
		for(ChequePayment payment:listCheque){
			System.out.println(payment);
		}
		
		System.out.println("-------------------------------------------");		
		//using CashPayment 
		query4=ses.createQuery("from CashPayment");
		listCash=query4.list();
		for(CashPayment payment:listCash){
			System.out.println(payment);
		}

	}//method
	
}//class
