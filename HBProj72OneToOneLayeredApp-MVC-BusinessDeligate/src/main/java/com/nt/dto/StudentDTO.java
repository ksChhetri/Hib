package com.nt.dto;

import com.nt.domain.LibraryMembership;

public class StudentDTO {
	private int sno;
	private String sname;
	private String sadd;
	
	private LibraryMembershipDTO libraryDetails;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	public LibraryMembershipDTO getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembershipDTO libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

}
