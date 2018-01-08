package com.nt.listeners;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class HibernateObjsClosingListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed(-)");
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized(-)");
				
	}

}
