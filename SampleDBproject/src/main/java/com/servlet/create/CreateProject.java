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

@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form data
        String projectCode = req.getParameter("projectCode");
        String projectTitle = req.getParameter("projectTitle");
        String projectDescription = req.getParameter("projectDescription");
        String customerId = req.getParameter("customerId");
        String location = req.getParameter("location");
        String projectValue = req.getParameter("projectValue");
        String currency = req.getParameter("currency");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String projectManager = req.getParameter("projectManager");
        String totalDeliveryMilestones = req.getParameter("totalDeliveryMilestones");
        String totalInvoiceMilestones = req.getParameter("totalInvoiceMilestones");
        String currentStatus = req.getParameter("currentStatus");
        String deviationsInTimeLimit = req.getParameter("deviationsInTimeLimit");
        String deviationsInEfforts = req.getParameter("deviationsInEfforts");
        String totalManDays = req.getParameter("totalManDays");
        String allottedManDays = req.getParameter("allottedManDays");
        String totalConsumed = req.getParameter("totalConsumed");
        String customerName = req.getParameter("customerName");

        // Database connection URL
        String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";

        // SQL insert statement
        String insert =
                "INSERT INTO sampleproject (ProjectCode, ProjectTitle, ProjectDescription, CustomerId, Location, ProjectValue, "
                + "Currency, StartDate, EndDate, ProjectManager, TotalDeliveryMilestones, TotalInvoiceMilestones, "
                + "CurrentStatus, DeviationsInTimeLimit, DeviationsInEfforts, TotalManDays, AllottedManDays, TotalConsumed, CustomerName) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            Connection connection = DriverManager.getConnection(url);
            // Prepare statement
            PreparedStatement ps = connection.prepareStatement(insert);

            // Set parameters
            ps.setString(1, projectCode);
            ps.setString(2, projectTitle);
            ps.setString(3, projectDescription);
            ps.setString(4, customerId);
            ps.setString(5, location);
            ps.setString(6, projectValue);
            ps.setString(7, currency);
            ps.setString(8, startDate);
            ps.setString(9, endDate);
            ps.setString(10, projectManager);
            ps.setString(11, totalDeliveryMilestones);
            ps.setString(12, totalInvoiceMilestones);
            ps.setString(13, currentStatus);
            ps.setString(14, deviationsInTimeLimit);
            ps.setString(15, deviationsInEfforts);
            ps.setString(16, totalManDays);
            ps.setString(17, allottedManDays);
            ps.setString(18, totalConsumed);
            ps.setString(19, customerName);

            // Execute update
            int result = ps.executeUpdate();
            if (result != 0) {
                resp.getWriter().println("Data Stored Successfully");
            } else {
                resp.getWriter().println("Failed to Store Data");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
