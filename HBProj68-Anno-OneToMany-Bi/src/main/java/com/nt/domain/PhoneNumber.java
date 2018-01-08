package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone_numbers")
public class PhoneNumber {
	@Id
	private long phone;
	@Column(name = "number_type")
	private String numberType;
	@ManyToOne(targetEntity=User.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="unid",referencedColumnName="user_id")
	private User parent;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:0-param constructor");
	}

	// setters & getters
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getNumberType() {
		return numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", numberType=" + numberType + "]";
	}
	
}