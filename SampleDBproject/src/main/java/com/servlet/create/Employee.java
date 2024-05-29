package com.servlet.create;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Employee1")
public class Employee extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String EmpId = req.getParameter("employeeId");
		String EmpName = req.getParameter("employeeName");
		String EmpDept = req.getParameter("employeeDept");
		String EmpDesignation = req.getParameter("employeeDesignation");
		
		String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		
		String insert=
			"insert into employee"
			+ "(EmpId,EmpName,EmpDept,EmpDesignation)"
			+ " values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection connection =	DriverManager.getConnection(url);
		PreparedStatement ps = connection.prepareStatement(insert);
		
		ps.setString(1, EmpId);
		ps.setString(2, EmpName);
		ps.setString(3, EmpDept);
		ps.setString(4, EmpDesignation);
		int result = ps.executeUpdate();
		//PrintWriter writer = resp.getWriter();
		if(result !=0 ) {
			resp.getWriter().println("Data Stored Sucess");
		}
		else {
			resp.getWriter().println(" failed Data");
		}
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().println("Error: "+e.getMessage());
		}
	}

}
