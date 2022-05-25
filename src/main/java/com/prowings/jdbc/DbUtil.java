package com.prowings.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	static Connection connection;
	
	public static Connection getDbConnection()
	{
	    try {
		      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "prowingsuser", "prowingsuser");
		      System.out.println("SQL Connection to database established!");
		    } catch (SQLException e) {
		      System.out.println("Connection Failed! Check output console");
		    } 
	    return connection;
	}
	
	public static void closeDbConnection()
	{
		      try
		      {
		        if(connection != null)
		          connection.close();
		        System.out.println("Connection closed !!");
		      }
		      catch (SQLException e) {
		       System.out.println("Error closing connection!!");
		    	  e.printStackTrace();
		      }

	}

}
