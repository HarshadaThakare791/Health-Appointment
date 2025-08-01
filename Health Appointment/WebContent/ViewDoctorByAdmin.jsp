<%@page import="java.sql.*"%>
<%@page import="myBankDB.ConnectDB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="Css/ViewDoctorByAdmin.css">
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
            <th>Delete</th>
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
            <td><a href="DeleteDoctor.jsp?did=<%=rs.getInt("did")%>">Delete</a></td>
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


