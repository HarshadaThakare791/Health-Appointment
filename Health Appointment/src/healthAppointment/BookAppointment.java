package healthAppointment;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DoctorPojo.Appointment;
import DoctorPojo.Doctor;
import DoctorPojo.PatientPojo;
import myBankDB.ConnectDB;



/**
 * Servlet implementation class BookAppointment
 */
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAppointment() {
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
	            
	            int pid = PatientPojo.getPid();  
	            int did = Integer.parseInt(request.getParameter("did")); 
	            String date = request.getParameter("date");
	            String time = request.getParameter("time");

	            
	            String dname = null;

	            Connection con = ConnectDB.getConnect();

	            
	            PreparedStatement psDoc = con.prepareStatement("SELECT dname FROM doctorinfo WHERE did = ?");
	            psDoc.setInt(1, did);
	            ResultSet rs = psDoc.executeQuery();
	            if (rs.next()) {
	                dname = rs.getString("dname");
	            } else {
	                throw new Exception("Doctor not found with ID: " + did);
	            }

	            
	            PreparedStatement ps1 = con.prepareStatement(
	                    "INSERT INTO appointments(pid, did, date, time, status, dname) VALUES(?,?,?,?,?,?)");

	            ps1.setInt(1, pid);
	            ps1.setInt(2, did);
	            ps1.setString(3, date);
	            ps1.setString(4, time);
	            ps1.setString(5, "Pending");
	            ps1.setString(6, dname);

	            int i = ps1.executeUpdate();

	            if (i > 0) {
	                System.out.println("Appointment booked successfully.");
	                response.sendRedirect("viewSpecificDoctor.jsp");
	            } else {
	                System.out.println("Failed to book appointment.");
	                response.sendRedirect("error.html");
	            }

	        } catch (Exception e) {
	            e.printStackTrace(); 
	            response.sendRedirect("error.html");
	        }
	    }
	}