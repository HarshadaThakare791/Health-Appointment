package healthAppointment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBankDB.ConnectDB;

/**
 * Servlet implementation class DeleteDoctor
 */
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctor() {
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
		
		try
		{
			
			    int did = Integer.parseInt(request.getParameter("did"));
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps1 = con.prepareStatement("select * from doctorinfo where did=?");
				ps1.setInt(1,did);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next())
				{
					PreparedStatement ps2 = con.prepareStatement("Delete from doctorinfo where did=?");
					ps2.setInt(1, did);
					int i = ps2.executeUpdate();
					
					if(i>0)
					{
						System.out.println("Deleted Succesfully....");
						response.sendRedirect("AdminDashboard.html");
					}
					else
					{
						System.out.println("Failed to Delete...!!");
						response.sendRedirect("error.html");

					}
				}
				else
				{
					System.err.println("Doctor information not found...!!!");	
					response.sendRedirect("error.html");
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	
	}

}
