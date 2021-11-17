package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cetagory  {
	public Connection getConnection() 
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://DESKTOP-QB12JA9\\SQLEXPRESS:1433;databaseName=QlSach;user=sa;password=123";
			return DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}	
}
