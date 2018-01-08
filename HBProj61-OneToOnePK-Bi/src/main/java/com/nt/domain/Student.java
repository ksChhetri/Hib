package com.nt.domain;

public class Student {
	private int sid;
	private String sname;
	private String sadd;
	private LibraryMembership libraryDetails;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	
	

}
