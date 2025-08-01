<%@page import="java.sql.*"%>
<%@page import="myBankDB.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Today Appointment</title>
<link rel="stylesheet" href="Css/ViewTodayAppointment.css">
</head>
<body>

<h2>View Appointments by Date</h2>

<form action="ViewTodayAppointment.jsp" >
    <input type="date" name="date" required>
    <input type="submit" value="View"> 
</form>

<%
    String date = request.getParameter("date");
    if(date != null && !date.trim().isEmpty()) {
        try {
            Connection con = ConnectDB.getConnect(); 
            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointments WHERE date = ?");
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
%>

<table border="1">
    <tr>
        <th>Aid</th>
        <th>Doctor Id</th>
        <th>Patient Id</th>
        <th>Date</th>
        <th>Time</th>
        <th>Status</th>
    </tr>

<%
            boolean hasResults = false;
            while(rs.next()) {
                hasResults = true;
%>
    <tr>
        <td><%= rs.getInt("Aid") %></td>
        <td><%= rs.getInt("did") %></td>
        <td><%= rs.getInt("pid") %></td>
        <td><%= rs.getString("date") %></td>
        <td><%= rs.getString("time") %></td>
        <td><%= rs.getString("status") %></td>
    </tr>
<%
            }
            if (!hasResults) {
%>
    <tr><td colspan="6">No appointments found for <%= date %>.</td></tr>
<%
            }
        } catch(Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        }
    }
%>
</table>

<br>
<a href="DoctorDashboard.html">Go to Dashboard</a>

</body>
</html>
