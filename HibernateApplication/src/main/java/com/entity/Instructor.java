package com.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="createtime")
	@CreationTimestamp
	private Timestamp createtime;
	
	@Column(name="modifytime")
	@UpdateTimestamp
	private Timestamp modifytime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="instructor_id")
	private InstructorDetail instructorDetail;
	
	public Instructor()
	{
		
	}
	
	public Instructor(String name, InstructorDetail instructorDetail) {
		super();
		this.name = name;
		this.instructorDetail = instructorDetail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Instructor [id=" + id + ", name=" + name + ", createtime=" + createtime + ", modifytime=" + modifytime
				+ ", instructorDetail=" + instructorDetail + "]";
	}

	
}
