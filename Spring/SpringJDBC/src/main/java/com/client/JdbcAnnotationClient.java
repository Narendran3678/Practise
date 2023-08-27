package com.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.config.SpringConfig;
import com.config.SpringJPAConfig;
import com.entity.Employee;
import com.hbm.EmployeeHbmDao;
import com.hbm.EmployeeJpaDao;

public class JdbcAnnotationClient {
	static EmployeeHbmDao employeeHbmDao;
	static EmployeeJpaDao employeejpaDao;
	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	static AnnotationConfigApplicationContext contextJpa = new AnnotationConfigApplicationContext(SpringJPAConfig.class);
	public static void main(String args[]){
		jpaDao();
	}
	public static void jpaDao()
	{
		if (context != null) {
			employeejpaDao = contextJpa.getBean("employeeJpaDao",EmployeeJpaDao.class);
			getjpaEmployees();
		}
	}
	public static void getjpaEmployees() {
		employeejpaDao.getEnities().forEach(System.out::println);
	}
	public static void hibDao()
	{
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
