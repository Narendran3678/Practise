package com.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	// ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY, CREATETIME,LASTMODIFIED
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="emailid")
	private String emailId;
	@Column(name="phonenumber")
	private String phoneNumber;
	@Column(name="salary")
	private Double salary;
	@Column(name="createtime")
	private Timestamp createTime;
	@Column(name="lastmodified")
	private Timestamp lastModifed;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String emailId, String phoneNumber, Double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}

	public Employee(Long id, String firstName, String lastName, String emailId, String phoneNumber, Double salary,
			Timestamp createTime, Timestamp lastModifed) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.createTime = createTime;
		this.lastModifed = lastModifed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLastModifed() {
		return lastModifed;
	}

	public void setLastModifed(Timestamp lastModifed) {
		this.lastModifed = lastModifed;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + ", createTime=" + createTime
				+ ", lastModifed=" + lastModifed + "]";
	}

}
