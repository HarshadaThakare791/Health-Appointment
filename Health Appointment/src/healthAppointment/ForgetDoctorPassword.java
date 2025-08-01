package healthAppointment;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBankDB.ConnectDB;

/**
 * Servlet implementation class ForgetDoctorPassword
 */
public class ForgetDoctorPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetDoctorPassword() {
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
			String demail = request.getParameter("demail");
			String dpassword = request.getParameter("dpassword");
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("update doctorinfo set dpassword=? where demail=?");
			ps.setString(1,dpassword);
			ps.setString(2, demail);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("Password Updated Successfully.");
				response.sendRedirect("DoctorLogin.html");
			}
			else{
				System.out.println("Invalide Email");
				response.sendRedirect("error.html");
			}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}
