package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee= new Employee();
		employee.setId(rs.getLong(1));
		employee.setFirstName(rs.getString(2));
		employee.setLastName(rs.getString(3));
		employee.setEmailId(rs.getString(4));
		employee.setPhoneNumber(rs.getString(5));
		employee.setSalary(rs.getDouble(6));
		employee.setCreateTime(rs.getTimestamp(7));
		employee.setLastModifed(rs.getTimestamp(8));
		return employee;
	}

}
