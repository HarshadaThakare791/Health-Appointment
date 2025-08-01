<%@page import="myBankDB.ConnectDB" %>
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>View Prescription</title>
 <link rel="stylesheet" href="Css/ViewPrescription.css">

</head>
<body>

    <h2>View Prescription</h2>

    <form method="post">
        <input type="text" name="Aid" placeholder="Enter Appointment ID" required>
        <button type="submit">Search</button>
    </form>

    
    <%
        String aid = request.getParameter("Aid");

        if (aid != null && !aid.trim().equals("")) {
            try {
                Connection con = ConnectDB.getConnect();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM addprescriptions WHERE Aid = ?");
                ps.setString(1, aid);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
    %>
    <table>
        <tr>
            <th>Prescription ID</th>
            <th>Appointment ID</th>
            <th>Doctor ID</th>
            <th>Prescription</th>
            <th>Date</th>
        </tr>
        <tr>
            <td><%= rs.getInt("preid") %></td>
            <td><%= rs.getString("Aid") %></td>
            <td><%= rs.getInt("did") %></td>
            <td><%= rs.getString("preText") %></td>
            <td><%= rs.getString("date") %></td>
        </tr>
    </table>
    <%
                } else {
    %>
        <p style='color:red;'>No prescription found for Appointment ID = <%= aid %></p>
    <%
                }
                con.close();
            } catch (Exception e) {
    %>
        <p style='color:red;'>Error: <%= e.getMessage() %></p>
    <%
            }
        }
    %>

    <a href="PatientDashboard.html">Go to Dashboard</a>
</body>
</html>
