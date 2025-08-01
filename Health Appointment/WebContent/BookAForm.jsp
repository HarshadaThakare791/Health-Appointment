<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book Appointment</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: url('https://thumbs.dreamstime.com/b/healthcare-technology-doctor-using-digital-tablet-icon-medical-network-hospital-background-162019727.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 60px;
        }

        form {
            background-color: rgba(255, 255, 255, 0.88);
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 350px;
        }

        h2 {
            color: #00796b;
            margin-bottom: 25px;
            background-color: rgba(255, 255, 255, 0.7);
            padding: 10px 20px;
            border-radius: 10px;
        }

        input[type="date"],
        input[type="time"],
        select {
            width: 100%;
            padding: 10px;
            margin: 12px 0;
            border: 1px solid #ccc;
            border-radius: 10px;
            font-size: 14px;
            box-sizing: border-box;
        }

        button {
            background-color: #4db6ac;
            color: white;
            border: none;
            padding: 12px 20px;
            margin-top: 15px;
            width: 100%;
            font-size: 16px;
            border-radius: 10px;
            cursor: pointer;
            transition: background 0.3s, transform 0.3s, box-shadow 0.3s;
        }

        button:hover {
            background-color: #00796b;
            transform: translateY(-2px);
            box-shadow: 0 6px 12px rgba(0, 121, 107, 0.3);
        }
    </style>
</head>
<body>
	<%
	String did = request.getParameter("did");
	String dname= request.getParameter("dname");
	%>

    <h2>Book Appointment Form</h2>
    <form action="BookAppointment" method="post">
    
        <input type="text" name="did" value=<%=did%> required><br>
        <input type="date" name="date" required><br>
        <input type="time" name="time" required><br>
        <input type="text" name="dname" value=<%=dname%> required><br>
        <br>
        <button type="submit">Submit</button>
    </form>

</body>
</html>
