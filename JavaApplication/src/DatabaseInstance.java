import java.sql.Connection;
import java.sql.DriverManager;

import com.annotation.DBType;
import com.annotation.DbConnection;
import com.annotation.DbDriver;
import com.annotation.DbPassword;
import com.annotation.DbUrl;
import com.annotation.DbUser;

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
	
	@DbConnection
	public Connection createConnection()
	{
		Connection connection = null;
		try
		{
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
