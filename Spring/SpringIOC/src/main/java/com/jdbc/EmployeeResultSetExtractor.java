package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeResultSetExtractor implements ResultSetExtractor<List<Employee>> {

	@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Employee> employeeList = new ArrayList<>();
		while(rs.next())
		{
			Employee employee= new Employee();
			employee.setId(rs.getLong(1));
			employee.setFirstName(rs.getString(2));
			employee.setLastName(rs.getString(3));
			employee.setEmailId(rs.getString(4));
			employee.setPhoneNumber(rs.getString(5));
			employee.setSalary(rs.getDouble(6));
			employee.setCreateTime(rs.getTimestamp(7));
			employee.setLastModifed(rs.getTimestamp(8));
			employeeList.add(employee);
		}
		return employeeList;
	}

}