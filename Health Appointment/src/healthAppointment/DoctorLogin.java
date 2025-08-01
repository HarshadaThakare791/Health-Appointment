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
 * Servlet implementation class DoctorLogin
 */
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLogin() {
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
		        String demail = request.getParameter("demail");
		        String dpassword = request.getParameter("dpassword");

		        Connection con = ConnectDB.getConnect();

		        PreparedStatement ps = con.prepareStatement("SELECT * FROM doctorinfo WHERE demail=? AND dpassword=?");
		        ps.setString(1, demail);
		        ps.setString(2, dpassword);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		        	String dname = rs.getString("dname");
		            Doctor.setDname(dname);  
		            int did = rs.getInt(1);
		            Doctor.setDid(did);  


		            PreparedStatement ps2 = con.prepareStatement("SELECT Aid FROM appointments WHERE did = ? LIMIT 1");
		            ps2.setInt(1, did);
		            ResultSet rs2 = ps2.executeQuery();
		            if (rs2.next()) {
		                Appointment.setAid(rs2.getInt("Aid"));
		            }

		           
		            response.sendRedirect("DoctorDashboard.html");
		        } else {
		            System.out.println("Invalid Email or Password");
		            response.sendRedirect("error.html");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        response.sendRedirect("error.html");
		    }
		}
	}
