package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Student_Tab")
public class Student {
	@Id
	@Column(name = "stno")
	private int sno;
	@Column(name = "stname")
	private String sname;
	@Column(name = "stadd")
	// @Transient
	private String sadd;

	@Version
	@Column(name = "ver_col")
	private int ver;

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
