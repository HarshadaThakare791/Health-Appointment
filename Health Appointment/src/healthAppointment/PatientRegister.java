package healthAppointment;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBankDB.ConnectDB;

/**
 * Servlet implementation class PatientRegister
 */
public class PatientRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegister() {
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
			int pid=0;
			String pname =request.getParameter("pname");
			String pcontact =request.getParameter("pcontact");
			String paddress =request.getParameter("paddress");
			String pemail =request.getParameter("pemail");
			String ppassword =request.getParameter("ppassword");
			
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps1 = con.prepareStatement("select * from patientregister where pemail=?");
			ps1.setString(1,pemail);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			  {
				System.out.println("Already register with this email..!!");
				response.sendRedirect("error.html");
			 }
				
		   else {
				
				
				PreparedStatement ps = con.prepareStatement("insert into patientregister values (?,?,?,?,?,?)");
				ps.setInt(1,pid);
				ps.setString(2, pname);
				ps.setString(3, pcontact);
				ps.setString(4, paddress);
				ps.setString(5, pemail);
				ps.setString(6, ppassword);
				int i = ps.executeUpdate();
				
				  if(i>0)
				  {
					System.out.println("Resister Successfully..!!");
					response.sendRedirect("patientLogin.html");
				  }
				  else{
					
					response.sendRedirect("error.html");
				  }
			}
	    }
		catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
