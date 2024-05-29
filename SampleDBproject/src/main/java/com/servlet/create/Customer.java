package com.servlet.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Customer")
public class Customer extends HttpServlet{
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String CustomerId = req.getParameter("customerId");
			String CustomerCode = req.getParameter("customerCode");
			String CustomerName = req.getParameter("customerName");
			String Location = req.getParameter("location");
			String AddressLine1 = req.getParameter("addressLine1");
			String AddressLine2 = req.getParameter("addressLine2");
			String AddressLine3 = req.getParameter("addressLine3");
			String City = req.getParameter("city");
			String TaxId = req.getParameter("taxId");
			String BankCode = req.getParameter("bankCode");
			String AccountNumber = req.getParameter("accountNumber");
			String Currency = req.getParameter("currency");
			
			String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
			
			String insert=
				"insert into customer"
				+ "(CustomerId,CustomerCode,CustomerName,Location,AddressLine1,"
				+ "AddressLine2,AddressLine3,City,TaxId,BankCode,AccountNumber,"
				+ "Currency)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection connection =	DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			
			ps.setString(1, CustomerId);
			ps.setString(2, CustomerCode);
			ps.setString(3, CustomerName);
			ps.setString(4, Location);
			ps.setString(5, AddressLine1);
			ps.setString(6, AddressLine2);
			ps.setString(7, AddressLine3);
			ps.setString(8, City);
			ps.setString(9, TaxId);
			ps.setString(10, BankCode);
			ps.setString(11, AccountNumber);
			ps.setString(12, Currency);
			
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