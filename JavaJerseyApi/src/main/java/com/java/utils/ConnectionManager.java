package com.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/devdb";
	private static String user = "root";
	private static String password = "root";
	private static ConnectionManager connectionManager = new ConnectionManager();
	private ConnectionManager() {
		ConnectionManager.createConnection();
	}

	public static synchronized ConnectionManager getInstance() {
		return connectionManager;
	}
	public Connection getConnection()
	{
		return connection;
	}
	private static Connection createConnection()
	{
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); //Compile Time Safety Check
			connection = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String args[])
	{
		System.out.println("Main Class");
		Connection connection = ConnectionManager.createConnection();
		if(connection == null)
		{
			System.out.println("No Connection");
		}
		else
		{
			System.out.println("Has Connection");
		}
	}
}
