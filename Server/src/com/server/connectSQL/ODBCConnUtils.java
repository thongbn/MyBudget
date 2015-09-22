package com.server.connectSQL;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ODBCConnUtils {

	public static Connection getJdbcOdbcConnection() throws SQLException,
			ClassNotFoundException {
		String odbcDataSourceName = "test1";
		String userName = "test1";
		String password = "test1";
		return getJdbcOdbcConnection(odbcDataSourceName, userName, password);
	}
	public static Connection getJdbcOdbcConnection(String odbcDataSourceName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("sun.jdbc.odbc.JdbcDriver");
		
		String connectionURL = "jdbc:odbc:test1";
		Connection conn = DriverManager.getConnection(connectionURL, userName,
	               password);
	    return conn;
	}
}
