package com.nt.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Student_Tab")
public class Student {
	/*@Id
	@Column(name = "stno")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")*/
	
	@Id
	@Column(name="stno")
	@GenericGenerator(name="gen1",
	                strategy="sequence",
	                parameters=@Parameter(name="sequence_name",value="sno_seq"))
	@GeneratedValue(generator="gen1")
	private int sno;
	
	@Column(name = "stname")
	private String sname;
	@Column(name = "stadd")
    // @Transient
	private String sadd;

	@Version
	@Column(name = "ver_col")
	private int ver;
	@Column(name="lastUpdated")
	@Temporal(value=TemporalType.DATE)
	private Date lastUpdated=new Date();

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

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

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + "]";
	}

}
