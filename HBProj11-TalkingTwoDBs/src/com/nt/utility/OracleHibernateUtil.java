package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleHibernateUtil {
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();  
	private static SessionFactory factory=null;
	static{
		factory=new Configuration().configure("/com/nt/cfgs/oracle-hibernate.cfg.xml").buildSessionFactory();
	}
	public static Session getSession(){
		 Session ses=null;
		 ses=threadLocal.get();
		if(ses==null){
			ses=factory.openSession();
			threadLocal.set(ses);
		}
		return ses;
	}//getSession()
	
	public static void closeSession(){
		Session ses=null;
		
		ses=threadLocal.get();
		if(ses!=null){
			ses.close();
			threadLocal.remove();
		}
	}
	
	public static void closeSessionFactory(){
		factory.close();
	}
	
}//class
