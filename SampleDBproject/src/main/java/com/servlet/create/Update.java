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

@WebServlet("/Update")
public class Update extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ProjectCode = req.getParameter("projectCode");
		String ProjectTitle = req.getParameter("projectTitle");
		String ProjectDescription = req.getParameter("projectDescription");
		String CustomerId = req.getParameter("customerId");
		String Location = req.getParameter("location");
		String ProjectValue = req.getParameter("projectValue");
		String Currency = req.getParameter("currency");
		String StartDate = req.getParameter("startDate");
		String EndDate = req.getParameter("endDate");
		String ProjectManager = req.getParameter("projectManager");
		String TotalDeliveryMilestones = req.getParameter("totalDeliveryMilestones");
		String TotalInvoiceMilestones = req.getParameter("totalInvoiceMilestones");
		String CurrentStatus = req.getParameter("currentStatus");
		String DeviationsinTimeLimit = req.getParameter("deviationsInTimeLimit");
		String DeviationsinEfforts = req.getParameter("deviationsInEfforts");
		String TotalManDays = req.getParameter("totalManDays");
		String AllottedManDays = req.getParameter("allottedManDays");
		String TotalConsumed = req.getParameter("totalConsumed");
		String CustomerName = req.getParameter("customerName");
		
		String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		String update = "update sampleproject set ProjectTitle=?,ProjectDescription=?,CustomerId=?,Location=?,ProjectValue=?,"
				+ "Currency=?,StartDate=?,EndDate=?,ProjectManager=?,TotalDeliveryMilestones=?,TotalInvoiceMilestones=?,"
				+ "CurrentStatus=?,DeviationsinTimeLimit=?,DeviationsinEfforts=?,TotalManDays=?,AllottedManDays=?,TotalConsumed=?,"
				+ "CustomerName=? where ProjectCode=?";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement ps = connection.prepareStatement(update);
				
				ps.setString(1, ProjectTitle);
				ps.setString(2, ProjectDescription);
				ps.setString(3, CustomerId);
				ps.setString(4, Location);
				ps.setString(5, ProjectValue);
				ps.setString(6, Currency);
				ps.setString(7, StartDate);
				ps.setString(8, EndDate);
				ps.setString(9, ProjectManager);
				ps.setString(10, TotalDeliveryMilestones);
				ps.setString(11, TotalInvoiceMilestones);
				ps.setString(12, CurrentStatus);
				ps.setString(13, DeviationsinTimeLimit);
				ps.setString(14, DeviationsinEfforts);
				ps.setString(15, TotalManDays);
				ps.setString(16, AllottedManDays);
				ps.setString(17, TotalConsumed);
				ps.setString(18, CustomerName);
				ps.setString(19, ProjectCode);
				
				int result = ps.executeUpdate();
				//PrintWriter writer = resp.getWriter();
				if(result !=0 ) {
					resp.getWriter().println("Data Updated");
				}
				else {
					resp.getWriter().println("Data Not Updated");
				}
			} catch (ClassNotFoundException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.getWriter().println("Error: "+e.getMessage());
			} 
	}

}


