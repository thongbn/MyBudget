package com.server.connectSQL;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class MySQLConnUtils {
	
	public static Connection getMySQLConnection() throws SQLException,
			ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "test1";
		String userName = "root";
		String password = "123456";
		
		return getMySQLConnection(hostName, dbName, userName, password);		
	}
	public static Connection getMySQLConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://localhost:3306/test1";
		
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

}
