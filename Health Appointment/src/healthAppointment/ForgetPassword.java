package healthAppointment;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBankDB.ConnectDB;

/**
 * Servlet implementation class ForgetPassword
 */
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("update admin set password=? where email=?");
			ps.setString(1,password);
			ps.setString(2, email);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("Password Updated Successfully.");
				response.sendRedirect("AdminLogin.html");
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
