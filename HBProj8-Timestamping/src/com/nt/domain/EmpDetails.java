//EmpDetails.java (BO class/Domain class/Entity class/Persistence class/Model class)
package com.nt.domain;

public class EmpDetails {
	private int no;
	private String fname;
	private String lname;
	private  String mail;
	private java.sql.Timestamp lastUpdated;
	
	public java.sql.Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(java.sql.Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
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
