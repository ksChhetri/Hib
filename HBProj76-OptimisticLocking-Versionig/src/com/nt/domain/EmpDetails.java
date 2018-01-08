//EmpDetails.java (BO class/Domain class/Entity class/Persistence class/Model class)
package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Employee")
public class EmpDetails {
	@Id
	@Column(name="eid")
	private int no;
	@Column(name="FirstName")
	private String fname;
	@Column(name="LastName")
	private String lname;
	@Column(name="email")
	private  String mail;
	@Version
	@Column(name="ver_col")
	private int ver;
	
	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

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
