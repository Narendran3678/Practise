package com.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entity.Employee;
import com.hbm.EmployeeHbmDao;
import com.jdbc.EmployeeDao;

public class JdbcClient {
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springfactory.xml");
	static EmployeeDao employeeDao;
	static EmployeeHbmDao employeeHbmDao;

	public static void main(String args[]) {
		//jdbcTemplate();
		hibernateTemplate();
	}

	public static void hibernateTemplate() {
		if (context != null) {
			employeeHbmDao = context.getBean("employeeHbmDao", EmployeeHbmDao.class);
			getHbmEmployees();
			//createHbmEmployee();
			context.close();
		}
	}
	public static void getHbmEmployees() {
		employeeHbmDao.getEnities().forEach(System.out::println);
	}
	public static void createHbmEmployee() {
		Employee employee = new Employee("Divya", "Naren", "divya@gmail.com", "8200212110", 30000d);
		System.out.println("Insert Status..." + employeeHbmDao.createEnity(employee));
	}

	public static void jdbcTemplate() {
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
		Employee employee = employeeDao.getEnity(101L);
		System.out.println(employee);
	}

	public static void createEmployee() {
		Employee employee = new Employee("Divya", "Naren", "divya@gmail.com", "8200212110", 30000d);
		System.out.println("Insert Status..." + employeeDao.createEnity(employee));
	}
}
