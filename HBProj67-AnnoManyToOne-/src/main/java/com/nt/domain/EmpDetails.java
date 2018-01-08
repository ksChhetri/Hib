package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EmpDetails")
public class EmpDetails {
	 @Id
	  @GenericGenerator(name="gen1",strategy="increment")
	  @GeneratedValue(generator="gen1")
	   private int eno;
	   private String ename;
	   private int salary;
	  @ManyToOne(targetEntity=Department.class,
			                     cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	  @JoinColumn(name="deptno",referencedColumnName="deptno")
	   private Department dept;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "EmpDetails [eno=" + eno + ", ename=" + ename + ", salary=" + salary + ", dept=" + dept + "]";
	}
}

