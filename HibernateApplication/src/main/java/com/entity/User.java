package com.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="phone_number")
	private String phonenumber;
	
	@Embedded
	@AttributeOverrides(
		value= {
				@AttributeOverride(name="addressLine1",column=@Column(name="house_number")),
				@AttributeOverride(name="addressLine2",column=@Column(name="street"))
		}
	)
	private Address address;
	
	@Embedded
	private Name name;

	public User()
	{
		
	}
	
	public User(String emailId, String phonenumber, Address address, Name name) {
		super();
		this.emailId = emailId;
		this.phonenumber = phonenumber;
		this.address = address;
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", phonenumber=" + phonenumber + ", address=" + address + ", name=" + name
				+ "]";
	}
}
