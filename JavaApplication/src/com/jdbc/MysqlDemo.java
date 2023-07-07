package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDemo {
	static Connection connection;
	static String url = "jdbc:mysql://localhost:3306/devdb";
	static String user = "root";
	static String password = "root";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		MysqlDemo md = new MysqlDemo();
		md.employeeInsert();

	}

	public void employeeInsert() {
		Connection connection = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/devdb", "root", "root");) {
			connection = con;
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(101, 'John', 'Smith', 12000)");
			stmt.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
	}

	public void employeeSelect() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/devdb", "root", "root");
			String query = "SELECT * FROM EMPLOYEE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("ID"));
				System.out.println("First Name: " + rs.getString("FIRSTNAME"));
				System.out.println("Last Name: " + rs.getString("LASTNAME"));
				System.out.println("Salary: " + rs.getDouble("SALARY"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void employeeAlias() {

		String url = "jdbc:mysql://localhost:3306/devdb";
		String user = "root";
		String password = "root";
		String query = "Select msg1 as msg, msg2 as msg FROM MESSAGES";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query);) {
			rs.absolute(1);
			System.out.println(rs.getString("msg"));
			System.out.println(rs.getString("msg"));
		} catch (SQLException e) {
			System.out.print(e);
		}
		/*
		 * String query = "DELETE FROM MESSAGES"; try { Statement stmt =
		 * connection.createStatement(); System.out.println(stmt.execute(query)); //
		 * Execute Return true resultSet has Row or else false } catch (SQLException e)
		 * { System.out.print(e); }
		 */
	}

	public void employeeAbsoluteRelative() {
		String query = "Select ID, FIRSTNAME, LASTNAME, SALARY FROM EMPLOYEE ORDER BY ID";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
			ResultSet rs = stmt.executeQuery(query);
			rs.relative(-3);
			rs.relative(1);
			System.out.println(rs.getInt(1));

			System.out.println();
			System.out.println("Employed Details....");
			// Absolute move pointer start from 1
			// Relative move pointer from current position
			rs.absolute(2);
			System.out.println("Current Row Pointer...\n" + rs.getString(1) + "-" + rs.getString(2) + "-"
					+ rs.getString(3) + "-" + rs.getString(4));
			rs.absolute(2);
			System.out.println("Current Row Pointer...\n" + rs.getString(1) + "-" + rs.getString(2) + "-"
					+ rs.getString(3) + "-" + rs.getString(4));
			rs.relative(-1);
			System.out.println("3rd Row Backward...\n" + rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3)
					+ "-" + rs.getString(4));
			rs.relative(1);
			System.out.println("1 Row Forward...\n" + rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3)
					+ "-" + rs.getString(4));

			rs.close();
		} catch (SQLException e) {
			System.out.print(e);
		}
	}

	public void test1() {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from customers");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + "-"
						+ rs.getString(4) + "-" + rs.getString(5));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void test2() {
		String query = "Select ID, FIRSTNAME, LASTNAME, SALARY FROM EMPLOYEE WHERE SALARY > 14900 ORDER BY ID";
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(query);) {

			rs.absolute(1);
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			rs.absolute(2);
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			// rs.updateDouble("SALARY", 20000);
			// rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}