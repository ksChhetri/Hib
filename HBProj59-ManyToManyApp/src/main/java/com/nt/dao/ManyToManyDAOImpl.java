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
	public void saveDataUsingProgrammer() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
	  // get Session 
		ses=HibernateUtil.getSession();
		//prepare Objects
		prgmr1=new Programmer();
		prgmr1.setPid(101); prgmr1.setPname("Raja"); prgmr1.setSalary(90000);
		prgmr2=new Programmer();
		prgmr2.setPid(102); prgmr2.setPname("ravi"); prgmr2.setSalary(80000);
		prgmr3=new Programmer();
		prgmr3.setPid(103); prgmr3.setPname("ramesh"); prgmr3.setSalary(70000);
		
		proj1=new Project();
		proj1.setProid(1001); proj1.setProname("Project1");
		proj2=new Project();
		proj2.setProid(1002); proj2.setProname("Project2");
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
			   ses.save(prgmr1); ses.save(prgmr2); ses.save(prgmr3);
			tx.commit();
			System.out.println("Objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
	}//method
	
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
	
	@Override
	public void listDataUsingProgrammer() {
		Session ses=null;
		Query query=null;
		List<Programmer> list=null;
	
		//get Session
		ses=HibernateUtil.getSession();
		//Load Programmers 
		query=ses.createQuery("from Programmer");
		list=query.list();
		list.forEach(prgmr->{
			System.out.println(prgmr);
			Set<Project> childs=prgmr.getProjects();
			childs.forEach(proj->{
				System.out.println(proj);
			});
		});
	}//method
	
	@Override
	public void listDataUsingProject() {
		Session ses=null;
		Query query=null;
		List<Project> list=null;
	
		//get Session
		ses=HibernateUtil.getSession();
		//Load Programmers 
		query=ses.createQuery("from Project");
		list=query.list();
		list.forEach(proj->{
			System.out.println(proj);
			Set<Programmer> childs=proj.getProgrammers();
			childs.forEach(prgmr->{
				System.out.println(prgmr);
			});
		});
		
	}//method
	
	@Override
	public void addExistingProgrammerToExistingProject() {
		Session ses=null;
		Programmer prgmr=null;
		Project proj=null;
	    Set<Programmer> set=null;
	    Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Existing Programmer (101)
		prgmr=ses.get(Programmer.class,101);
		//get Existing Project
		proj=ses.get(Project.class,1004);
		//get All Programmer of 1004 project
		set=proj.getProgrammers();
		//add 101 programmer to the existing 1004 project
		try{
			tx=ses.beginTransaction();
			   set.add(prgmr);
			tx.commit();
			System.out.println("Existing Programmer is added to Exiting Project");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void moveExistingProgrammerToExistingProject() {
		Session ses=null;
		Programmer prgmr=null;
		Project proj1=null,proj2=null;
	    Set<Programmer> prgmrSet1=null,prgmrSet2=null;
	    Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Existing Programmer (103)
		prgmr=ses.get(Programmer.class,103);
		//get all programmers of 1001 project
		proj1=ses.get(Project.class,1001);
		prgmrSet1=proj1.getProgrammers();
		//get all programmers of 1003 project
		proj2=ses.get(Project.class,1003);
		prgmrSet2=proj2.getProgrammers();
		// Remove existing programmer from Existing Project and add to Another Project
		try{
			//Remove 103 programmer from existing project 1001
			tx=ses.beginTransaction();
			  prgmrSet1.remove(prgmr);
			tx.commit();
			System.out.println("103 Programmer is removed from 1001 project");
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
		try{
			//Add 103 programmer to existing project 1003
			tx=ses.beginTransaction();
			  prgmrSet2.add(prgmr);
			tx.commit();
			System.out.println("103 Programmer  is added to 1003 project");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
}//class
