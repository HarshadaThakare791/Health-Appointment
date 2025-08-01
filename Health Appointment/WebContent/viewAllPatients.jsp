<%@page import="myBankDB.ConnectDB" %>
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="Css/viewAllPatients.css">
</head>
<body>
<table>
    <thead>
        <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Contact</th>
   <th>Address</th>
   <th>Email</th>
   
    </tr>
   </thead>
  <tbody>
   <%
   try{
	    Connection con = ConnectDB.getConnect(); 
		PreparedStatement ps = con.prepareStatement("select * from patientregister");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
	%>
			<tr>
			  <td><%=rs.getString(1)%></td>
			  <td><%=rs.getString(2)%></td>
			  <td><%=rs.getString(3)%></td>
			  <td><%=rs.getString(4)%></td>
			  <td><%=rs.getString(5)%></td>
			 
			 </tr> 
  <% 
		}
		
		
	}
	catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("error.html");
	}
	
   %>
</table>
<a href="AdminDashboard.html">Go to Dashboard</a>
</body>
</html>