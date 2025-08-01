package healthAppointment;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBankDB.ConnectDB;

/**
 * Servlet implementation class UpdateStatus
 */
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
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
	}
}