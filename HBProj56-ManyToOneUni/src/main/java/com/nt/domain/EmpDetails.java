package com.nt.domain;

public class EmpDetails {
	private int eno;
	private String ename;
	private String job;
	private Department dept;
	
	public EmpDetails() {
		System.out.println("EmpDetails::0-param constructor");
	}
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmpDetails [eno=" + eno + ", ename=" + ename + ", job=" + job + "]";
	}
}
