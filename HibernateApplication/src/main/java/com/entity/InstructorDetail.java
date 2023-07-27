package com.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructor_Detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private Long instructorId;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="createtime")
	@CreationTimestamp
	private Timestamp createtime;
	
	@Column(name="modifytime")
	@UpdateTimestamp
	private Timestamp modifytime;
	
	public InstructorDetail()
	{
		
	}

	public InstructorDetail(String emailId, String phoneNumber) {
		super();
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
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

	public Timestamp getModifytime() {
		return modifytime;
	}

	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	@Override
	public String toString() {
		return "InstructorDetail [instructorId=" + instructorId + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", createtime=" + createtime + ", modifytime=" + modifytime + "]";
	}
	
	
}
