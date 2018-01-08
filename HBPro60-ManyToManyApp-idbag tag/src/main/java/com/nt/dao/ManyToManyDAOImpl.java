package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO{
	
	
	@Override
	public void saveDataUsingProject() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
	  // get Session 
		ses=HibernateUtil.getSession();
		//prepare Objects
		prgmr1=new Programmer();
		prgmr1.setPid(104); prgmr1.setPname("ramesh"); prgmr1.setSalary(90000);
		prgmr2=new Programmer();
		prgmr2.setPid(105); prgmr2.setPname("rajesh"); prgmr2.setSalary(80000);
		prgmr3=new Programmer();
		prgmr3.setPid(106); prgmr3.setPname("karan"); prgmr3.setSalary(70000);
		
		proj1=new Project();
		proj1.setProid(1003); proj1.setProname("Project3");
		proj2=new Project();
		proj2.setProid(1004); proj2.setProname("Project4");
		//add programmers to projects and vice-versa.
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr3);
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr2);
		proj2.getProgrammers().add(prgmr3);
		
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		prgmr2.getProjects().add(proj2);
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		
	
		//save object (parent to child)
		try{
			tx=ses.beginTransaction();
			   ses.save(proj1); ses.save(proj2); 
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		
	}//method
}//class
