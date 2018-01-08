package com.nt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.utility.HibernateUtil;

public class SessionFactoryClosingContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed()");
		  HibernateUtil.closeSession();
		  HibernateUtil.closeSessionFactory();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized()");
		
	}
}//class
