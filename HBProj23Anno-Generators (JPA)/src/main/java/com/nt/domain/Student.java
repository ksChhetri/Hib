package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Student_Tab")
public class Student {
	
	/*@Id
	@Column(name="stno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	
	/*@Id
	@Column(name="stno")
	@SequenceGenerator(name="gen1",
	                   sequenceName="stno_seq1",
	                   initialValue=10,
	                   allocationSize=20
            	                 )
	@GeneratedValue(generator="gen1",
	                strategy=GenerationType.SEQUENCE)*/
	
/*	@Id
	@Column(name="stno")
	@TableGenerator(name="gen1",
	               table="ID_GEN",
	               pkColumnName="PK_COL",
	               valueColumnName="PK_VAL",
	               pkColumnValue="STNO",
	               initialValue=100,
	               allocationSize=5
	               )
	@GeneratedValue(generator="gen1",
	                strategy=GenerationType.TABLE)*/
	@Id
	@Column(name="stno")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sno;
	
	
	
	@Column(name = "stname")
	private String sname;
	@Column(name = "stadd")
    // @Transient
	private String sadd;

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
