package healthAppointment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import myBankDB.ConnectDB;

/**
 * Servlet implementation class AddDoctor
 */
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
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
			int did=0;
			
			String dname =(request.getParameter("dname"));
			String dspecialization =(request.getParameter("dspecialization"));
			String dcontact =request.getParameter("dcontact");
			String demail =request.getParameter("demail");
			String dpassword =request.getParameter("dpassword");
			Connection con = ConnectDB.getConnect(); 
			
			
			PreparedStatement ps = con.prepareStatement("select * from doctorinfo where demail=?");
			ps.setString(1, demail);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println(" Already Register with this Email ..!!");
				response.sendRedirect("error.html");
			}
			else
			{
			
					PreparedStatement ps1 = con.prepareStatement("insert into doctorinfo values(?,?,?,?,?,?)");
					ps1.setInt(1,did);
					ps1.setString(2, dname);
					ps1.setString(3,dspecialization);
					ps1.setString(4, dcontact);
					ps1.setString(5, demail);
					ps1.setString(6,dpassword);
					
					
					int i = ps1.executeUpdate();
					
						if(i>0){
							System.out.println("Record inserted....");
							response.sendRedirect("AdminDashboard.html");
						}
						else{
							System.out.println("Failed to insert..!!");
							response.sendRedirect("error.html");
						}
					
					}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
