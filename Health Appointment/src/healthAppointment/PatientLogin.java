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
 * Servlet implementation class PatientLogin
 */
public class PatientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientLogin() {
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
		try{
			String pemail = request.getParameter("pemail");
			String ppassword = request.getParameter("ppassword");
			
			System.out.println(ppassword);
			System.out.println(pemail);
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("select * from patientregister where pemail=? and ppassword=?");
			ps.setString(1, pemail);
			ps.setString(2, ppassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				
				PatientPojo.setPid(rs.getInt(1));
				response.sendRedirect("PatientDashboard.html");
				
			}
			else{
				
				System.out.println("Invalide Email or Password");
				response.sendRedirect("error.html");
			}
			
			}
			catch(Exception e){
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
	}

}
