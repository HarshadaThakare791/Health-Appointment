package myBankDB;

import java.sql.*;

public class ConnectDB {
 
   static Connection con = null; 
   public static Connection getConnect(){
	   
	 try{
		 
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meddb","root", "");
		 System.out.println("Connection established");
		 
	 }
	 catch(Exception e){
		 System.out.println("Failed Connection...!!");
		 e.printStackTrace();
		 
	 }
	 return con;
	 
 }
	
}
