package com.server.getBudget;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.server.connectSQL.ConnectionUtils;


public class ReadFile extends AbstractHandler {
	public void handle(String arg0, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		response.setContentType("application/json;charset=utf-8");
	    response.setStatus(HttpServletResponse.SC_OK);
	    baseRequest.setHandled(true);
	    Connection connection = null;
		try {
			connection = ConnectionUtils.getMyConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "Select Emp_Id, Emp_No, Emp_Name from Employee";
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			while (rs.next()) {
				 int empId = rs.getInt(1);
				 String empNo = rs.getString(2);
				 String empName = rs.getString("Emp_Name");
				 
				 response.getWriter().println("-----------");
				 response.getWriter().println ("EmpId:" + empId);
				 response.getWriter().println ("EmpNo:" + empNo);
				 response.getWriter().println ("EmpName:" + empName);
			
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}