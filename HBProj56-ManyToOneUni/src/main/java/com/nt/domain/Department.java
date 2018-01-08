package com.nt.domain;

public class Department {
	private int deptno;
	private  String deptname;
	private String depthead;
	
	public Department() {
		System.out.println("Department:0-param constructor");
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDepthead() {
		return depthead;
	}
	public void setDepthead(String depthead) {
		this.depthead = depthead;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + ", depthead=" + depthead + "]";
	}

	 
}
