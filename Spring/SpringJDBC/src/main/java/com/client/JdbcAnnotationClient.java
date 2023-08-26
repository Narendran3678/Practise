package com.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.config.SpringConfig;
import com.entity.Employee;
import com.hbm.EmployeeHbmDao;

public class JdbcAnnotationClient {
	static EmployeeHbmDao employeeHbmDao;
	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	public static void main(String args[]){
		if (context != null) {
			employeeHbmDao = context.getBean("employeeHdmDao",EmployeeHbmDao.class);
			getHbmEmployees();
			//createHbmEmployee();
		}
	}
	public static void getHbmEmployees() {
		employeeHbmDao.getEnities().forEach(System.out::println);
	}
	public static void createHbmEmployee() {
		Employee employee = new Employee("Divya", "Naren", "divya@gmail.com", "8200212110", 30000d);
		System.out.println("Insert Status..." + employeeHbmDao.createEnity(employee));
	}
}
