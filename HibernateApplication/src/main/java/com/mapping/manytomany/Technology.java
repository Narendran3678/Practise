package com.mapping.manytomany;

import java.util.*;
import com.entity.DAOI;
import jakarta.persistence.*;

@Entity
@Table(name="technology")
public class Technology extends DAOI {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="tech_name")
	private String technologyName;

	@Column(name="tech_version")
	private String technologyVersion;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "techList",fetch = FetchType.EAGER)
	private Set<Project> projectList = new HashSet<>();

	public Technology() {
		
	}
	
	public Technology(String technologyName, String technologyVersion) {
		super();
		this.technologyName = technologyName;
		this.technologyVersion = technologyVersion;
	}

	public Technology(String technologyName, String technologyVersion, Set<Project> projectList) {
		super();
		this.technologyName = technologyName;
		this.technologyVersion = technologyVersion;
		this.projectList = projectList;
	}
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	public String getTechnologyVersion() {
		return technologyVersion;
	}
	public void setTechnologyVersion(String technologyVersion) {
		this.technologyVersion = technologyVersion;
	}
	public Set<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(Set<Project> projectList) {
		this.projectList = projectList;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Technology [id=" + id + ", technologyName=" + technologyName + ", technologyVersion="
				+ technologyVersion +"]";
	}
	
	
	
}
