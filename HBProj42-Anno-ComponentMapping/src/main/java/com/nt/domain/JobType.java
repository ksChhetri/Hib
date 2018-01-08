package com.nt.domain;

import javax.persistence.Embeddable;

@Embeddable
public class JobType {
	private String desg;
	private String dept;
	private int salary;
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "JobType [desg=" + desg + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	

}
