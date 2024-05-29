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

@WebServlet("/Task")
public class Task extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ProjectCode = req.getParameterValues("projectCode");
		String[] SrNo = req.getParameterValues("srNo");
		String[] TaskCode = req.getParameterValues("taskCode");
		String[] TaskName = req.getParameterValues("taskName");
		String[] DependableTaskCode = req.getParameterValues("dependableTaskCode");
		String[] SimultaneousTasks = req.getParameterValues("simultaneousTasks");
		String[] PlannedtoStartDate = req.getParameterValues("plannedtoStartDate");
		String[] PlannedtoEndDate = req.getParameterValues("plannedtoEndDate");
		String[] ActualStartDate = req.getParameterValues("actualStartDate");
		String[] ActualEndDate = req.getParameterValues("actualEndDate");
		String[] SignOff = req.getParameterValues("signOff");
		String[] Invoice = req.getParameterValues("invoice");
		String[] AllocatedDays = req.getParameterValues("allocatedDays");
		String[] ActualDays = req.getParameterValues("actualDays");
		String[] Description = req.getParameterValues("taskDescription");
		
		
		 
		 String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		 String insert = "insert into task(ProjectCode,SrNo,TaskCode,TaskName,DependableTaskCode,"
			 		+ "SimultaneousTasks,PlannedtoStartDate,PlannedtoEndDate,ActualStartDate,ActualEndDate,"
			 		+ "SignOff,Invoice,AllocatedDays,ActualDays,Description)"
					 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			
			for(int i=0;i<ProjectCode.length;i++) {
				ps.setString(1, ProjectCode[i]);
				ps.setString(2, SrNo[i]);
				ps.setString(3, TaskCode[i]);
				ps.setString(4, TaskName[i]);
				ps.setString(5, DependableTaskCode[i]);
				ps.setString(6, SimultaneousTasks[i]);
				ps.setString(7, PlannedtoStartDate[i]);
				ps.setString(8, PlannedtoEndDate[i]);
				ps.setString(9, ActualStartDate[i]);
				ps.setString(10, ActualEndDate[i]);
				ps.setString(11, SignOff[i]);
				ps.setString(12, Invoice[i]);
				ps.setString(13, AllocatedDays[i]);
				ps.setString(14, ActualDays[i]);
				ps.setString(15, Description[i]);
				
				int result = ps.executeUpdate();
				//PrintWriter writer = resp.getWriter();
				if(result !=0 ) {
					resp.getWriter().println("Data Stored Sucessfully");
				}
				else {
					resp.getWriter().println(" failed to store Data");
				}
				
			}
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().println("Error: "+e.getMessage());
		}
	}

}
