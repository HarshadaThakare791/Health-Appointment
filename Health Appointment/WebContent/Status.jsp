<%@ page import="DoctorPojo.Appointment" %>
<%@ page import="DoctorPojo.Doctor" %>
<%@ page import="myBankDB.ConnectDB" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
try {
    int aid = Integer.parseInt(request.getParameter("Aid"));

    Connection con = ConnectDB.getConnect();
    PreparedStatement ps = con.prepareStatement("UPDATE appointments SET status='Accepted' WHERE Aid=?");
    ps.setInt(1, aid);

    int i = ps.executeUpdate();

    if (i > 0) {
        System.out.println("Appointment status updated to Accepted");
        response.sendRedirect("ViewAppointment.jsp"); 
    } else {
        System.out.println("Update failed");
        response.sendRedirect("error.html");
    }
} catch (Exception e) {
    e.printStackTrace();
    response.sendRedirect("error.html");
}

%>



</body>
</html>