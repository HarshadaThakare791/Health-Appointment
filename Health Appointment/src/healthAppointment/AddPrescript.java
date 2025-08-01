package healthAppointment;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DoctorPojo.Doctor;
import myBankDB.ConnectDB;

/**
 * Servlet implementation class AdminLogin
 */
public class AddPrescript extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPrescript() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try {
	        int did = Doctor.getDid();  // Doctor ID from session/static
	        String Aid = request.getParameter("Aid");
	        String preText = request.getParameter("preText");
	        String date = request.getParameter("date");

	        Connection con = ConnectDB.getConnect(); 

	        // Insert into prescriptions table
	        PreparedStatement ps = con.prepareStatement(
	            "INSERT INTO addprescriptions (Aid, did, preText, date) VALUES (?, ?, ?, ?)"
	        );

	        ps.setString(1, Aid);
	        ps.setInt(2, did);
	        ps.setString(3, preText);
	        ps.setString(4, date);

	        int i = ps.executeUpdate();

	        if (i > 0) {
	            System.out.println("Prescription added successfully.");
	            response.sendRedirect("DoctorDashboard.html");
	        } else {
	            System.out.println("Failed to add prescription.");
	            response.sendRedirect("error.html");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("error.html");
	    }
	}
}