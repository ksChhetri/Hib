package com.nt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Lib_Membership")
public class LibraryMembership {
	@Id
	@GenericGenerator(name="gen1",strategy="foreign",
	                                        parameters=@Parameter(name="property",value="studentDetails"))
	@GeneratedValue(generator="gen1")
	private int lid;
	
	private Date doj;
	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="lid",referencedColumnName="sno")
	private Student studentDetails;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Student getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", doj=" + doj + "]";
	}
	
	

}
