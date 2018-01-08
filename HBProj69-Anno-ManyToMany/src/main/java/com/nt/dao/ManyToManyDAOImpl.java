package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Programmer prgmr1=null,prgmr2=null,prgmr3=null;
		Project proj1=null,proj2=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		prgmr1=new Programmer();
		prgmr1.setPid(1);
		prgmr1.setPname("raja");
		prgmr1.setSalary(5000);
		
		prgmr2=new Programmer();
		prgmr2.setPid(2);
		prgmr2.setPname("ravi");
		prgmr2.setSalary(6000);
		
		prgmr3=new Programmer();
		prgmr3.setPid(3);
		prgmr3.setPname("Codesh");
		prgmr3.setSalary(9000);
		
		proj1=new Project();
		proj1.setProid(1001);
		proj1.setProname("proj1");
		
		proj2=new Project();
		proj2.setProid(1002);
		proj2.setProname("proj2");
		
		//add projects to programmers
		prgmr1.getProjects().add(proj1);
		prgmr1.getProjects().add(proj2);
		prgmr2.getProjects().add(proj2);
		prgmr3.getProjects().add(proj1);
		prgmr3.getProjects().add(proj2);
		//add Projects to Programmers
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr3);
		proj2.getProgrammers().add(prgmr1);
		proj2.getProgrammers().add(prgmr2);
		proj2.getProgrammers().add(prgmr3);
		//Save objects (ManyTo Many -->parent to child)
		try{
			tx=ses.beginTransaction();
			  ses.save(prgmr1); ses.save(prgmr2); ses.save(prgmr3);
			tx.commit();
			System.out.println("Objects are saved...");
		}//try
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
	}//method
}//class
