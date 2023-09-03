package com.creational.prototype;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.lang3.SerializationUtils;

class Address implements Serializable
{
	private static final long serialVersionUID = 1L;
	String addressLine1;
	String country;
	String zipcode;
	public Address(String addressLine1, String country, String zipcode) {
		super();
		this.addressLine1 = addressLine1;
		this.country = country;
		this.zipcode = zipcode;
	}
	public Address(Address copyAddress)
	{
		this.addressLine1 = copyAddress.addressLine1;
		this.country = copyAddress.country;
		this.zipcode = copyAddress.zipcode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", Country=" + country + ", zipcode=" + zipcode + "]";
	}
}
class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	String[] personName;
	String emailId;
	String phoneNumber;
	Address address;
	
	public Person(String[] personName, String emailId, String phoneNumber, Address address) {
		super();
		this.personName = personName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public Person(Person copyPerson)
	{
		this.personName=copyPerson.personName;
		this.emailId = copyPerson.emailId;
		this.phoneNumber= copyPerson.phoneNumber;
		this.address = new Address(copyPerson.address);
	}

	public String[] getPersonName() {
		return personName;
	}

	public void setPersonName(String[] personName) {
		this.personName = personName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [personName=" + Arrays.toString(personName) + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", address=" + address + "]";
	}

}
public class PrototypePattern {
	public static void main(String args[])
	{
		Address address = new Address("29 Nattar Street","India","605004");
		Person naren = new Person(new String[] {"Naren"} ,"narendran3678@gmail.com","7092802533",address);
		
		
		Person divya = SerializationUtils.roundtrip(naren); // new Person(naren);
		divya.setPersonName(new String[] {"divya","naren"});
		
		System.out.println(naren);
		System.out.println(divya);
	}
}
