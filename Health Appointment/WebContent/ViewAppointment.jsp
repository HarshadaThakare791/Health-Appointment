<%@page import="myBankDB.ConnectDB" %>
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="DoctorPojo.Doctor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="Css/ViewAppointment.css">
</head>
<body>
<h1>View All Appointments</h1>
<table>
<tr>
   <th>Appointment Id</th>
   <th>Patient Id</th>
   <th>Doctor Id</th>
   <th>Date</th>
   <th>Time</th>
   <th>Status</th>
   </tr>
   
   <%
   try{
	    int did= Doctor.getDid();
	    Connection con = ConnectDB.getConnect(); 
		PreparedStatement ps = con.prepareStatement("select * from appointments where did=?");
		ps.setInt(1, did);
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
			  <td><%=rs.getString(6)%></td>
			  <td><a href="Status.jsp?Aid=<%=rs.getInt("Aid")%>">Accepted</a></td>
			 </tr> 
  <% 
		}
		
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
   %>
</table>
<a href="DoctorDashboard.html" class="dashboard-button">Go to Dashboard</a>
</body>
</html>
