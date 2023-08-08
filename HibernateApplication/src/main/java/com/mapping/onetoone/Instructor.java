package com.mapping.onetoone;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.entity.DAOI;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor extends DAOI {
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
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="id")  // Indicated that Instructor will have foriegn key column and name suggest that foriegn key mapping column name
	private InstructorDetail instructorDetail;
	
	public Instructor()
	{
		
	}
	public Instructor(String name) {
		super();
		this.name = name;
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
