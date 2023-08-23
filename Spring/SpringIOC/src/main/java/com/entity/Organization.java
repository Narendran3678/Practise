package com.entity;

import java.util.*;

public class Organization {
	private String organizationName;
	private String hQBase;
	private List<Employee> employees =  new ArrayList<>();
	
	public Organization()
	{
		
	}

	public Organization(String organizationName, String hQBase) {
		super();
		this.organizationName = organizationName;
		this.hQBase = hQBase;
	}

	public Organization(String organizationName, String hQBase, List<Employee> employees) {
		super();
		this.organizationName = organizationName;
		this.hQBase = hQBase;
		this.employees = employees;
	}


	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String gethQBase() {
		return hQBase;
	}

	public void sethQBase(String hQBase) {
		this.hQBase = hQBase;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Organization [organizationName=" + organizationName + ", hQBase=" + hQBase + ", employees=" + employees
				+ "]";
	}
	
	
}
