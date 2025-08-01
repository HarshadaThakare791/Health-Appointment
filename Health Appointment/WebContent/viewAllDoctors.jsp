<%@page import="myBankDB.ConnectDB" %>
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Doctors</title>
<link rel="stylesheet" type="text/css" href="Css/viewAllDoctors.css">
</head>
<body>

<h1>All Doctor Records</h1>

<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Specialist Of</th>
            <th>Contact</th>
            <th>Email</th>
            
        </tr>
    </thead>
    <tbody>
    <%
        try {
            Connection con = ConnectDB.getConnect(); 
            PreparedStatement ps = con.prepareStatement("SELECT * FROM doctorinfo");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
    %>
        <tr>
            <td><%= rs.getString(1) %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><%= rs.getString(5) %></td>
            
        </tr>
    <%
            }
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    %>
    </tbody>
</table>

<br>
<a href="AdminDashboard.html">Go to Dashboard</a>

</body>
</html>
