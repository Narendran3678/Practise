package com.java.Service;
import java.util.*;
import com.java.DAO.EmployeeDAO;
import com.java.Entity.Employee;
public class EmployeeService {
	private static EmployeeService service = new EmployeeService();
	
	private EmployeeService() {
	}

	public static synchronized EmployeeService getInstance() {
		return service;
	}
	public List<Employee> getEmployeeList()
	{
		return EmployeeDAO.getInstance().getEmployeeList();
	}
	public Employee getEmployeeDetail(Long empId)
	{
		return EmployeeDAO.getInstance().getEmployeeDetail(empId);
	}
	public boolean createEmployee(Employee employee)
	{
		return EmployeeDAO.getInstance().createEmployee(employee);
	}
}
