package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class GetObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;

		//Activate HB framework based on jars added to build path
		cfg=new Configuration();
		//use hibernate.cfg.xml file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");

		//set hibernate connection,mapping file info
		cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username","system");
		cfg.setProperty("hibernate.connection.password","manager1");
		cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		cfg.setProperty("hibernate.show_sql","true");
		cfg.setProperty("hibernate.format_sql","true");
		//add mapping file
		cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");

		//build SessionFactory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		 //get Object
		details=ses.get(EmpDetails.class,9867);
		if(details!=null)
			System.out.println(details);
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class
