package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost/reminder","root", "");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return con;
	}

}
 