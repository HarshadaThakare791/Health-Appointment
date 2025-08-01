<%@page import="java.sql.*"%>
<%@page import="myBankDB.ConnectDB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="Css/viewSpecificDoctor.css">
</head>
<body>
 <form action="viewSpecificDoctor.jsp">
       <input type="text" name="dspecialization" placeholder="Which Specialist Doctor you want ?">
       <input type="submit" name="View"> 
       
       <%
       try{
    	   String dspecialization = request.getParameter("dspecialization");
    	   if(dspecialization!=null)
    	  {
    		   %>
  <table>
    <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Specialist Of</th>
   <th>Contact</th>
   <th>Email</th>
   
      
    </tr>
       
       <% 
       
        Connection con = ConnectDB.getConnect(); 
		PreparedStatement ps = con.prepareStatement("select * from doctorinfo where dspecialization=?");
		ps.setString(1,dspecialization);
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
			   <td><a href="BookAForm.jsp?did=<%=rs.getString(1)%>">Book Appointment with Doctor</a></td>
			  
			 </tr> 
        <% 
    	   }
       }
      }
       catch(Exception e){
    	   e.printStackTrace();
    	   response.sendRedirect("error.html");
       }
      
       %>
  </table>
           
       </form>
      
        <a href="PatientDashboard.html">Go to Patient Dashboard</a>
        <a href="AdminDashboard.html">Go to Admin Dashboard</a>
</body>
</html>