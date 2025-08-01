<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="myBankDB.ConnectDB" %>
<%@ page import="DoctorPojo.PatientPojo" %>
<%@ page import="DoctorPojo.Doctor" %>
<%@ page import="DoctorPojo.Appointment" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>My Appointments</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #e0f7fa;
            padding: 40px;
            text-align: center;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            margin-top: 30px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #00796b;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        h2 {
            color: #004d40;
        }
    </style>
</head>
<body>

<h2>My Appointments</h2>

<%
    int pid = PatientPojo.getPid(); 
    try {
        Connection con = ConnectDB.getConnect();
        PreparedStatement ps = con.prepareStatement("SELECT Aid, status, date FROM appointments WHERE pid = ?");
        ps.setInt(1, pid);
        ResultSet rs = ps.executeQuery();

        boolean found = false;
%>
        <table>
            <tr>
                <th>Appointment ID</th>
                <th>Status</th>
                <th>Date</th>
            </tr>

<%
        while (rs.next()) {
            found = true;
%>
            <tr>
                <td><%= rs.getString("Aid") %></td>
                <td><%= rs.getString("status") %></td>
                <td><%= rs.getString("date") %></td>
            </tr>
<%
        }

        if (!found) {
%>
            <tr><td colspan="3">No appointments found.</td></tr>
<%
        }

        con.close();
    } catch (Exception e) {
%>
    <p>Error: <%= e.getMessage() %></p>
<%
    }
%>

</table>

</body>
</html>
