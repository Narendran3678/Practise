package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Name {

	//@Enumerated(EnumType.ORDINAL)
	@Enumerated(EnumType.STRING)
	@Column(name="salutation")
	private Salutation salutation;
	
	@Column(name="first_name")	
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	public Name()
	{
		
	}
	
	public Name(Salutation salutation, String firstName, String lastName) {
		super();
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [salutation=" + salutation + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
