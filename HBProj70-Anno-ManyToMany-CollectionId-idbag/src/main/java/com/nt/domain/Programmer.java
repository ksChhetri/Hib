package com.nt.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="programmers")
public class Programmer {
	@Id
    private int pid;
    private String pname;
    private int salary;
    @ManyToMany(targetEntity=Project.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name="programmers_projects",
                           joinColumns=@JoinColumn(name="programmer_id",referencedColumnName="pid"),
                           inverseJoinColumns=@JoinColumn(name="project_id",referencedColumnName="proid")
                         )
    @GenericGenerator(name="gen1",strategy="increment")
    @CollectionId(generator="gen1",
                                columns=@Column(name="prgmr_proj_index"),
                                type=@Type(type="int")
                              )
                                
    private List<Project>projects=new ArrayList();
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Programmer [pid=" + pid + ", pname=" + pname + ", salary=" + salary + ", projects=" + projects + "]";
	}
	
}
