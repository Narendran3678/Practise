package com.entity;

public class Employee {
	private String employeeName;
	private String employeeLocation;
	private int experience;
	
	public Employee()
	{
		
	}
	
	public Employee(String employeeName, String employeeLocation, int experience) {
		super();
		this.employeeName = employeeName;
		this.employeeLocation = employeeLocation;
		this.experience = experience;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeLocation=" + employeeLocation + ", experience="
				+ experience + "]";
	}
	
	
}
