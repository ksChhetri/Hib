package com.nt.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@Column(name = "user_id")
	@GenericGenerator(strategy="increment",name="gen1")
	@GeneratedValue(generator="gen1")
	private int userId;
	@Column(name = "first_name")
	private String firstName;
	
	@OneToMany(targetEntity = PhoneNumber.class, 
			                     cascade = CascadeType.ALL,
			                     fetch = FetchType.EAGER,
			                     orphanRemoval=true)
	  @Fetch(value=FetchMode.JOIN)
	@JoinColumn(name = "unid", referencedColumnName = "user_id")
	private Set<PhoneNumber> phones;
	
  	public User() {
		System.out.println("User:0-param constructor");
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", phones=" + phones + "]";
	}
}