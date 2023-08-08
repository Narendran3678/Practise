package com.mapping.onetoone;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.entity.DAOI;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructor_Detail")
public class InstructorDetail extends DAOI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private Long id;
	
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
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="instructorDetail") // mapped by Suggest that variable name in instructor map
	private Instructor instructor;
	
	public InstructorDetail()
	{
		
	}

	public InstructorDetail(String emailId, String phoneNumber) {
		super();
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	public InstructorDetail(String emailId, String phoneNumber,Instructor instructor) {
		super();
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.instructor = instructor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Instructor getInstructorObj() {
		return instructor;
	}

	public void setInstructorObj(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", createtime=" + createtime + ", modifytime=" + modifytime + ", instructor="
				+ instructor + "]";
	}
	
}
