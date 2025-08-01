<%@page import="myBankDB.ConnectDB" %>
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Css/DeleteDoctor.css">
</head>
<body>
<%
try
{   

	    Connection con = ConnectDB.getConnect();
	    String did =request.getParameter("did");
		PreparedStatement ps1 = con.prepareStatement("delete from doctorinfo where did=?");
		ps1.setString(1,did);
		int i = ps1.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("ViewDoctorByAdmin.jsp");
			
		}
		else
		{
			System.err.println("Doctor info not found...!!!");	
			response.sendRedirect("error.html");
			
			
		}
	
}
catch(Exception e)
{
	e.printStackTrace();
	response.sendRedirect("error.html");
}
%>
</body>
</html>