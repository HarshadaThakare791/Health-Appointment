<%@page import="java.sql.*"%>
<%@page import="myBankDB.ConnectDB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="Css/viewSpecificPatient.css">
</head>
<body>
 <form action="viewSpecificPatient.jsp">
       <input type="text" name="pname" placeholder="Enter name of Patient">
       <input type="submit" name="View"> 
      <%
       try{
    	   String pname = request.getParameter("pname");
    	   System.out.println(pname);
    	   if(pname!=null)
    	  {
    		   %>
    <table>
    <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Contact</th>
   <th>Address</th>
   <th>Email</th>
  
      
    </tr>
       
       <% 
       
        Connection con = ConnectDB.getConnect(); 
		PreparedStatement ps = con.prepareStatement("select * from patientregister where pname=?");
		ps.setString(1,pname);
		System.out.println(pname);
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
      }
       catch(Exception e){
    	   e.printStackTrace();
    	   response.sendRedirect("error.html");
       }
      
       %>
  </table>
           
       </form>
       <a href="AdminDashboard.html">Go to Dashboard</a>
</body>
</html>>