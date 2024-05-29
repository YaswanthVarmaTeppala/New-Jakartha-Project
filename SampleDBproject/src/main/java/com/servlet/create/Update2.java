package com.servlet.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update2")
public class Update2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ProjectCode = Integer.parseInt(req.getParameter("ProjectCode"));
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM sampleproject WHERE projectCode=?");
            ps.setInt(1, ProjectCode);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                out.println("<html><body>");
                out.println("<h2>Update Project</h2>");
                out.println("<form action='Update2' method='post'>");
                out.println("<input type='hidden' name='projectCode' value='" + ProjectCode + "'/>");
                out.println("ProjectTitle: <input type='text' name='ProjectTitle' value='" + rs.getString("ProjectTitle") + "'/><br/>");
                out.println("ProjectDescription: <input type='text' name='ProjectDescription' value='" + rs.getString("ProjectDescription") + "'/><br/>");
                out.println("CustomerId: <input type='number' name='CustomerId' value='" + rs.getString("CustomerId") + "'/><br/>");
                out.println("Location: <input type='text' name='Location' value='" + rs.getString("Location") + "'/><br/>");
                out.println("ProjectValue: <input type='text' name='ProjectValue' value='" + rs.getString("ProjectValue") + "'/><br/>");
                out.println("Currency: <input type='text' name='Currency' value='" + rs.getString("Currency") + "'/><br/>");
                out.println("StartDate: <input type='date' name='StartDate' value='" + rs.getString("StartDate") + "'/><br/>");
                out.println("EndDate: <input type='date' name='EndDate' value='" + rs.getString("EndDate") + "'/><br/>");
                out.println("ProjectManager: <input type='text' name='ProjectManager' value='" + rs.getString("ProjectManager") + "'/><br/>");
                out.println("TotalDeliveryMileStones: <input type='number' name='TotalDeliveryMileStones' value='" + rs.getString("TotalDeliveryMileStones") + "'/><br/>");
                out.println("TotalInvoiceMileStones: <input type='number' name='TotalInvoiceMileStones' value='" + rs.getString("TotalInvoiceMileStones") + "'/><br/>");
                out.println("CurrentStatus: <input type='text' name='CurrentStatus' value='" + rs.getString("CurrentStatus") + "'/><br/>");
                out.println("DeviationsinTimeLimit: <input type='number' name='DeviationsinTimeLimit' value='" + rs.getString("DeviationsinTimeLimit") + "'/><br/>");
                out.println("DeviationsinEfforts: <input type='number' name='DeviationsinEfforts' value='" + rs.getString("DeviationsinEfforts") + "'/><br/>");
                out.println("TotalManDays: <input type='number' name='TotalManDays' value='" + rs.getString("TotalManDays") + "'/><br/>");
                out.println("AllotedManDays: <input type='number' name='AllottedManDays' value='" + rs.getString("AllottedManDays") + "'/><br/>");
                out.println("TotalConsumed: <input type='number' name='TotalConsumed' value='" + rs.getString("TotalConsumed") + "'/><br/>");
                out.println("Customername: <input type='text' name='Customername' value='" + rs.getString("Customername") + "'/><br/>");
                out.println("ProjectCode: <input type='text' name='ProjectCode' value='" + rs.getString("ProjectCode") + "'/><br/>");
                // Add more form fields here for each column
                out.println("<input type='submit' value='Update' />");
                out.println("</form>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int ProjectCode = Integer.parseInt(req.getParameter("ProjectCode"));
    	
//    	int ProjectCode;
//        try {
//            ProjectCode = Integer.parseInt(req.getParameter("ProjectCode"));
//        } catch (NumberFormatException e) {
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid project code format");
//            return;
//        }
        String ProjectTitle = req.getParameter("ProjectTitle");
        String ProjectDescription = req.getParameter("ProjectDescription");
        String CustomerId = req.getParameter("CustomerId");
        String Location = req.getParameter("Location");
        String ProjectValue = req.getParameter("ProjectValue");
        String Currency = req.getParameter("Currency");
        String StartDate = req.getParameter("StartDate");
        String EndDate = req.getParameter("EndDate");
        String ProjectManager = req.getParameter("ProjectManager");
        String TotalDeliveryMileStones = req.getParameter("TotalDeliveryMileStones");
        String TotalInvoiceMileStones = req.getParameter("TotalInvoiceMileStones");
        String CurrentStatus = req.getParameter("CurrentStatus");
        String DeviationsinTimeLimit = req.getParameter("DeviationsinTimeLimit");
        String DeviationsinEfforts = req.getParameter("DeviationsinEfforts");
        String TotalManDays = req.getParameter("TotalManDays");
        String AllottedManDays = req.getParameter("AllottedManDays");
        String TotalConsumed = req.getParameter("TotalConsumed");
        String Customername = req.getParameter("Customername");
     
        // Get other parameters similarly
        
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
            ps.setString(10, TotalDeliveryMileStones);
            ps.setString(11, TotalInvoiceMileStones);
            ps.setString(12, CurrentStatus);
            ps.setString(13, DeviationsinTimeLimit);
            ps.setString(14, DeviationsinEfforts);
            ps.setString(15, TotalManDays);
            ps.setString(16, AllottedManDays);
            ps.setString(17, TotalConsumed);
            ps.setString(18, Customername);
            ps.setInt(19, ProjectCode);
            // Set other parameters similarly
            ps.executeUpdate();
            resp.sendRedirect("DisplayRecords");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}