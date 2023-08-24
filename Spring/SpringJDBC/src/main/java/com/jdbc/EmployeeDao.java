package com.jdbc;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entity.Employee;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	private String SELECT_ALL_QUERY = "SELECT ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY, CREATETIME, LASTMODIFIED FROM EMPLOYEE";
	private String SELECT_QUERY = "SELECT ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY, CREATETIME, LASTMODIFIED FROM EMPLOYEE WHERE ID=?";
	private String INSERT_QUERY = "INSERT INTO EMPLOYEE( FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY) VALUES(?,?,?,?,?)";
	private String UPDATE_QUERY = "UPDATE EMPLOYEE SET PHONENUMBER=?,SALARY=? WHERE ID= ?";
	private String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID= ?";

	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Employee> getEnities() {
		List<Employee> employeeList = jdbcTemplate.query(SELECT_ALL_QUERY, new EmployeeResultSetExtractor());
		return employeeList;
	}

	public Employee getEnity(Long id) {
		Employee employee = jdbcTemplate.queryForObject(SELECT_QUERY, new EmployeeRowMapper(), id);
		return employee;
	}

	public boolean createEnity(Employee employee) {
		boolean insertStatus = jdbcTemplate.update(INSERT_QUERY, employee.getFirstName(), employee.getLastName(),
				employee.getEmailId(), employee.getPhoneNumber(), employee.getSalary()) > 0 ? true : false;
		return insertStatus;
	}

	public boolean updateEnity(Employee employee, Long id) {
		boolean updateStatus = jdbcTemplate.update(UPDATE_QUERY, employee.getPhoneNumber(), employee.getSalary(),
				id) > 0 ? true : false;
		return updateStatus;
	}

	public boolean deleteEnity(Long id) {
		boolean deleteStatus = jdbcTemplate.update(DELETE_QUERY, id) > 0 ? true : false;
		return deleteStatus;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
