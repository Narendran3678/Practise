package com.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Project {

	private String name;
	private String team;
	private String projectManager;

	Project() {
	}

	public Project(String name, String team, String projectManager) {
		this.name = name;
		this.team = team;
		this.projectManager = projectManager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/*
	 * @Override public String toString() { return "Project [name=" + name +
	 * ", team=" + team + ", projectManager=" + projectManager + "]"; }
	 */
}

class Employee {

	private String id;
	private String firstName;
	private String lastName;
	private int salary;
	private int totalLaptopsAssigned;
	// OneToMany
	private List<Project> projects;

	Employee() {
	}

	public Employee(String id, String firstName, String lastName, int salary, int totalLaptopsAssigned,
			List<Project> projects) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.totalLaptopsAssigned = totalLaptopsAssigned;
		this.projects = projects;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(this.id, this.firstName, this.lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Employee e = (Employee) obj;

		if (e.getId() == this.getId() && e.getFirstName().equals(this.getFirstName())
				&& e.getFirstName().equals(this.getFirstName())) {
			return true;
		} else
			return false;

	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getTotalLaptopsAssigned() {
		return totalLaptopsAssigned;
	}

	public void setTotalLaptopsAssigned(int totalLaptopsAssigned) {
		this.totalLaptopsAssigned = totalLaptopsAssigned;
	}
}

class EmployeeFirstNameSort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getFirstName().compareTo(o2.getFirstName()) > 0)
			return 1;
		else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0)
			return -1;
		else
			return 0;
	}

}

class EmployeeFactory extends Employee {

	ArrayList<Employee> employees = new ArrayList<>();

	public List<Employee> getAllEmployee() {

		Project Delta = new Project("Delta Model", "Login", "Robert Downey Jr");
		Project Beta = new Project("Beta Enhancement", "Authentication", "Chris");
		Project TwoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
		Project CommonUI = new Project("Common UI", "UI", "Robert Downey Jr");
		Project Pegasus = new Project("Pegasus Model", "Data", "Vikram");
		Project CustomerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
		Project Verification = new Project("Source Verification", "Data", "Pablo");
		Project RemoveUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
		Project SiteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
		Project DataTransition = new Project("Data Transition", "Data", "Atif Aslam");
		Project TwoPhaseDeployment = new Project("Two Phase Deployment", "Deployment", "Shaktiman");

		employees.add(new Employee("2020Emp0234", "Bhaskar", "Sharan", 900000, 1, Arrays.asList(Delta, Beta)));
		employees.add(new Employee("2012Emp1923", "Dev", "Sharma", 3500000, 3,
				Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
		employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 1800000, 3,
				Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
		employees.add(new Employee("2017Emp00031", "Chris", "Martin", 2200000, 2, Arrays.asList(Delta, TwoFactorAuth)));
		employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 2200000, 3,
				Arrays.asList(Pegasus, Delta, RemoveUsers, DataTransition)));
		employees.add(new Employee("2022Emp0087", "Babu", "Rao", 900000, 1, Arrays.asList(TwoFactorAuth)));
		employees.add(new Employee("2019Emp0050", "Dev", "Anand", 1300000, 1, Arrays.asList(RemoveUsers, CommonUI)));
		employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 1100000, 1, Arrays.asList(Pegasus)));
		employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 1200000, 0, Arrays.asList(Delta)));
		employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2,
				Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));
		employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2,
				Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));
		return employees;
	}
}

class EmployeeSalarySort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.getSalary() > o2.getSalary())
			return 1;
		else if (o1.getSalary() < o2.getSalary())
			return -1;
		else
			return 0;
	}

}

public class StreamClassDemo {
	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		EmployeeFactory employeeFactory = new EmployeeFactory();
		employeeList = employeeFactory.getAllEmployee();
		// method1();
		method2();
		//thirdLargestSalaryEmployee();
		// minimumSalaryEmployee();
		// employeeWorkingMoreProject();
		// employeesLaptopCount();
		// specifiedPMprojectCount();
		// employeeWithYear();
	}
	
	public static void employeeWithYear() // Not working Completely
	{
		employeeList.stream().collect(HashMap::new, (acc_map, emp) -> {
			acc_map.put(emp.getId().substring(0, 4), emp);
		}, Map::putAll).forEach((k, v) -> System.out.println(k + "=" + v));
	}

	public static void specifiedPMprojectCount() {
		long count = employeeList.stream().flatMap(s -> s.getProjects().stream()).distinct()
				.filter(s -> s.getProjectManager().equals("Shaktiman")).count();

		System.out.println("PM Project Count..." + count);
	}

	public static void employeesLaptopCount() {
		long count = employeeList.stream().mapToInt(s -> s.getTotalLaptopsAssigned()).sum();
		System.out.println("Employee with Laptop Count..." + count);
	}

	public static void employeeWorkingMoreProject() {
		System.out.println("Employee with More Project...");
		List<Employee> empList = employeeList.stream().filter(s -> s.getProjects().size() > 1)
				.collect(Collectors.toList());
		empList.forEach(System.out::println);
	}

	public static void minimumSalaryEmployee() {
		System.out.println("Employee with Minimum Salary...");
		List<Employee> salaryGroupEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary))
				.entrySet().stream().sorted((o1, o2) -> {
					if (o1.getKey() > o2.getKey()) {
						return 1;
					} else if (o1.getKey() < o2.getKey())
						return -1;
					else
						return 0;
				}).map(k -> k.getValue()).findFirst().get();
		salaryGroupEmp.forEach(System.out::println);
	}

	public static void thirdLargestSalaryEmployee() {
		System.out.println("Employee with 3rd Salary...");
		List<Employee> salaryGroupEmp = employeeList.stream().collect(Collectors.groupingBy(s -> s.getSalary()))
				.entrySet().stream().sorted((o1, o2) -> {
					if (o1.getKey() > o2.getKey()) {
						return 1;
					} else if (o1.getKey() < o2.getKey())
						return -1;
					else
						return 0;
				}).skip(2).findFirst()
				// .map(Map.Entry::getValue)
				.map((map) -> {
					return map.getValue();
				}).get();

		salaryGroupEmp.forEach(System.out::println);

	}
	public static void method2() {
		List<String> listArr = new ArrayList<String>();
	    listArr.add("Naren");
	    listArr.add("Divya");
	    listArr.add("Vinoth");
	    listArr.stream().collect( () ->{ 
								    	return new HashMap<String,Integer>();
								    },
    								(hmap,str) -> {
								    	hmap.put(str,str.length());
    									},
    										(map1,map2) -> {
    											map1.putAll(map2);
    										}
									).forEach( (key,value) -> {
										System.out.println(key+"="+value);
									} 
								);
	}
	public static void method1() {
		System.out.println("Employee Initial Count...." + employeeList.size());
		long uniqueCount = employeeList.stream().distinct().count();
		System.out.println("Unique Record Count...." + uniqueCount);
		System.out.println();

		System.out.println("Employee Sorted with FirstName...");
		employeeList.stream().sorted(new EmployeeFirstNameSort()).map(s -> s.getFirstName() + "=" + s.getSalary())
				.forEach(System.out::println);
		System.out.println();

		System.out.println("Employee Sorted with Salary...");
		employeeList.stream().sorted(new EmployeeSalarySort()).map(s -> s.getFirstName() + "=" + s.getSalary())
				.forEach(System.out::println);
		System.out.println();
	}
}
