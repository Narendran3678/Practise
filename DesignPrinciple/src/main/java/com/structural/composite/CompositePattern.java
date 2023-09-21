package com.structural.composite;

import java.util.*;

interface Organization {
	public void print();

	public void add(Employee employee);

	public void remove(Employee employee);
}

class Project implements Organization {
	private List<Employee> employees = new ArrayList<>();
	private String projectName;
	
	public Project(List<Employee> employees, String projectName) {
		super();
		this.employees = employees;
		this.projectName = projectName;
	}

	public Project(String projectName) {
		super();
		this.projectName = projectName;
	}

	@Override
	public void print() {
		employees.forEach(System.out::println);
	}
	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public void remove(Employee employee) {
		employees.remove(employee);
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}

abstract class Employee {
	long empId;
	String employeeName;
	double salary;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

}

class Developer extends Employee {
	private String devManager;
	public Developer(long empId,String employeeName ,double salary,String devManager)
	{
		super.employeeName = employeeName;
		super.empId = empId;
		super.salary = salary;
		this.devManager =devManager;
	}
	@Override
	public String toString() {
		return "Developer [devManager=" + devManager + ", empId=" + empId + ", employeeName=" + employeeName
				+ ", salary=" + salary + "]";
	}
}

class QualityAnalyst extends Employee {
	private String qaManager;
	public QualityAnalyst(long empId,String employeeName ,double salary,String qaManager)
	{
		super.employeeName = employeeName;
		super.empId = empId;
		super.salary = salary;
		this.qaManager = qaManager;
	}
	@Override
	public String toString() {
		return "QualityAnalyst [qaManager=" + qaManager + ", empId=" + empId + ", employeeName=" + employeeName
				+ ", salary=" + salary + "]";
	}
}
/*
 * If we need to create a structure where Objects in the structure are to be treated the same, a composite design pattern is preferred
 */
public class CompositePattern {
	public static void main(String[] args) {
		Project project = new Project("CAFE");
		Employee emp = new Developer(1184252,"Naren",34000,"Amal Janarthanan");
		Employee emp1 = new QualityAnalyst(131554,"Divya",24000,"Vignesh");
		project.add(emp);
		project.add(emp1);
		
		project.print();
	}
}
