package com.servlet.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayRecords")
public class DisplayRecords extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String ProjectCode = req.getParameter("ProjectCode");
		out.print("<h1>Display the records</h1>");
		out.print("<table border='1'><tr><th>ProjectCode</th><th>ProjectTitle</th><th>ProjectDescription</th>"
				+ "<th>CustomerId</th><th>Location</th><th>ProjectValue</th><th>Currency</th><th>StartDate</th>"
				+ "<th>EndDate</th><th>ProjectManager</th><th>TotalDeliveryMileStones</th><th>TotalInvoiceMileStones</th><th>CurrentStatus</th>"
				+ "<th>DeviationsinTimeLimit</th><th>DeviationsinEfforts</th><th>TotalManDays</th><th>AllottedManDays</th>"
				+ "<th>TotalConsumed</th><th>CustomerName</th></tr>"); 
		
		String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			Statement st = connection.createStatement();
			ResultSet rs;
			if (ProjectCode != null && !ProjectCode.isEmpty()) {
			    rs = st.executeQuery("select * from sampleproject where ProjectCode=" + ProjectCode);
			} else {
			    rs = st.executeQuery("select * from sampleproject");
			}
			
			while(rs.next()) {
	
				out.print("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(6));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(7));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(8));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(9));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(10));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(11));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(12));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(13));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(14));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(15));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(16));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(17));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(18));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(19));
				out.print("</td>");
				out.print("<td>");
				out.print("<a href='Update2?ProjectCode=" + rs.getInt(1) + "'>Edit</a>");
				out.print("</td>");
				out.print("</tr>");
				
			}//<td><a href='UpdateRecord?id=" + rs.getInt("id") + "'>Edit</a></td>
		}
		catch(Exception p) {
			System.out.println(p);
		}
		out.print("</table>");
		
	}

}
