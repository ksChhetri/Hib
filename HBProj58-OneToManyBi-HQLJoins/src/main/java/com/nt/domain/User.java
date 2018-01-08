package com.nt.domain;

import java.util.Set;

public class User {
	private int userId;
	private String first_name;
	private Set<PhoneNumber> phones;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public Set<PhoneNumber> getPhones() {
		return phones;
	}
	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", first_name=" + first_name + "]";
	}
   
}
