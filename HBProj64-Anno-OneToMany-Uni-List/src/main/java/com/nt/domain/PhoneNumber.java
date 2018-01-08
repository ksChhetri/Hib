package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone_numbers1")
public class PhoneNumber {
	@Id
	private long phone;
	@Column(name = "number_type")
	private String numberType;
	
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

	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", numberType=" + numberType + "]";
	}
	
}