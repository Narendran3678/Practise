package com.annotation;
import java.sql.Connection;
import java.sql.DriverManager;

@DBType
public class DatabaseInstance 
{	
	@DbDriver
	public String dbDriver;
	
	@DbUrl
	public String dbUrl;

	@DbUser
	public String dbUserName;
	
	@DbPassword
	public String dbPassword;
	
	public DatabaseInstance() {
		
	}
	@DbConnection
	public Connection createConnection()
	{
		Connection connection = null;
		try
		{
			System.out.println("Annotation Set");
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
}
