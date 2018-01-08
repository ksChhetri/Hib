//EmpDetails.java (BO class/Domain class/Entity class/Persistence class/Model class)
package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@NamedQueries({@NamedQuery(name="GET_EMPS_By_DOMAIN",
                   query="from EmpDetails where mail like:dmn"),
		
		        @NamedQuery(name="DELETE_EMPS",
		                 query="delete from EmpDetails where lname=:surname")
                }
              )

public class EmpDetails {
	@Id
	@Column(name="EID")
	private int no;
	@Column(name="FIRSTNAME")
	private String fname;
	@Column(name="LASTNAME")
	private String lname;
	@Column(name="EMAIL")
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
