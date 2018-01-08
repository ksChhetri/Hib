//EmpDetails.java (BO class/Domain class/Entity class/Persistence class/Model class)
package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@NamedNativeQueries(value={@NamedNativeQuery(name="GET_EMPS",
                                    query="select * from Employee",
                                    resultClass=EmpDetails.class),
		
		                   @NamedNativeQuery(name="GET_EMPS_BY_DOMAIN",
		                                     query="select eid,firstname from Employee where email like :dmn"),
		                   
		                   @NamedNativeQuery(name="DELETE_EMPS_BY_LASTNAME",
		                                     query="delete from Employee where LASTNAME=:surname")
                          }
                   )

public class EmpDetails {
	@Id
	@Column(name="eid")
	private int no;
	@Column(name="firstname")
	private String fname;
	@Column(name="lastname")
	private String lname;
	@Column(name="email")
	private  String mail;
	
	public EmpDetails() {
		System.out.println("EmpDetails:0-param constructor");
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "EmpDetails [no=" + no + ", fname=" + fname + ", lname=" + lname + ", mail=" + mail + "]";
	}

}
