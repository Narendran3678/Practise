	package com.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcClient {
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springfactory.xml");
	static EmployeeDao employeeDao;
	public static void main(String args[]) {
		if (context != null) {
			employeeDao = context.getBean("employeeDao", EmployeeDao.class);
			//getEmployees();
			//getEmployee(101L);
			createEmployee();
			context.close();
		}
	}
	
	public static void getEmployees() {
		employeeDao.getEnities().forEach(System.out::println);
	}
	public static void getEmployee(Long id) {
		Employee employee=employeeDao.getEnity(101L);
		System.out.println(employee);
	}
	public static void createEmployee() {
		Employee employee = new Employee("Divya","Naren","divya@gmail.com","8200212110",30000d);
		System.out.println("Insert Status..."+employeeDao.createEnity(employee));
	}
}
