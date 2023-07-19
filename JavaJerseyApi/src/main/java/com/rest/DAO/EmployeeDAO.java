package com.rest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.rest.Entity.Employee;
import com.rest.utils.ConnectionManager;

public class EmployeeDAO {
	private static EmployeeDAO empDao = new EmployeeDAO();

	private EmployeeDAO() {
	}

	public static synchronized EmployeeDAO getInstance() {
		return empDao;
	}

	public boolean createEmployee(Employee employee) {
		boolean status = false;
		PreparedStatement preStatement = null;
		ResultSet result = null;
		Connection connection = ConnectionManager.getInstance().getConnection();
		String sql = "insert into employee ( FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY) values "
				+ "(?,?,?,?,?)";
		try {
			preStatement = connection.prepareStatement(sql);
			preStatement.setString(1, employee.getFirstName());
			preStatement.setString(2, employee.getLastName());
			preStatement.setString(3, employee.getEmailid());
			preStatement.setString(4, employee.getPhonenumber());
			preStatement.setDouble(5, employee.getSalary());
			int insertStatus = preStatement.executeUpdate();
			if (insertStatus > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public Employee getEmployeeDetail(Long empId) {
		PreparedStatement preStatement = null;
		ResultSet result = null;
		Employee employee = null;
		Connection connection = ConnectionManager.getInstance().getConnection();
		String sql = "SELECT ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY, CREATETIME FROM EMPLOYEE WHERE ID = ?";
		try {
			preStatement = connection.prepareStatement(sql);
			preStatement.setLong(1, empId);
			result = preStatement.executeQuery();
			while (result.next()) {
				employee = new Employee();
				employee.setId(result.getInt(1));
				employee.setFirstName(result.getString(2));
				employee.setLastName(result.getString(3));
				employee.setEmailid(result.getString(4));
				employee.setPhonenumber(result.getString(5));
				employee.setSalary(result.getDouble(6));
				employee.setCreatetime(result.getDate(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	public List<Employee> getEmployeeList() {
		Statement statement = null;
		ResultSet result = null;
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = ConnectionManager.getInstance().getConnection();
		String sql = "SELECT ID, FIRSTNAME, LASTNAME, EMAILID, PHONENUMBER, SALARY, CREATETIME FROM EMPLOYEE ";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				Employee employee = new Employee();
				employee.setId(result.getInt(1));
				employee.setFirstName(result.getString(2));
				employee.setLastName(result.getString(3));
				employee.setEmailid(result.getString(4));
				employee.setPhonenumber(result.getString(5));
				employee.setSalary(result.getDouble(6));
				employee.setCreatetime(result.getDate(7));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employeeList;
	}
}
