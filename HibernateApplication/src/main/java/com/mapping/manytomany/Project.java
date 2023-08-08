package com.mapping.manytomany;

import java.util.HashSet;
import java.util.Set;

import com.entity.DAOI;

import jakarta.persistence.*;

@Entity
@Table(name="project")
public class Project extends DAOI  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_lead")
	private String projectLead;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="project_technology",
		joinColumns = {
				@JoinColumn(name="project_id"),
		},
		inverseJoinColumns = {
				@JoinColumn(name="tech_id")
		}
	)
	private Set<Technology> techList = new HashSet<>();

	public Project()
	{
		
	}
	
	public Project(String projectName, String projectLead) {
		super();
		this.projectName = projectName;
		this.projectLead = projectLead;
	}

	public Project(String projectName, String projectLead, Set<Technology> techList) {
		super();
		this.projectName = projectName;
		this.projectLead = projectLead;
		this.techList = techList;
	}

	public long getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectLead() {
		return projectLead;
	}

	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}

	public Set<Technology> getTechList() {
		return techList;
	}

	public void setTechList(Set<Technology> techList) {
		this.techList = techList;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectLead=" + projectLead + "]";
	}
}
