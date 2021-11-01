package com.niru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;

import com.mysql.cj.protocol.Resultset;



@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Pattern for mail check
		 String regex = "^(.+)@(.+)$";  
		 Connection conn=null;
			PrintWriter out=response.getWriter();

		
		 //Getting user data in variable.....................
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		//Matching with the pattern of the email...........
		 Pattern pattern = Pattern.compile(regex);  
		 
		 //Calling to match the email.............
		   Matcher matcher = pattern.matcher(email);  
		   
		   
		   //If email is in correct format then database connectivity................. 
		  
		   if(matcher.matches()){
			   try{
					
				   // calling the jdbc driver class............
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// Managing connection with database...................
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
					
					// Writing Query to perform operation....................
					String query="select Email,Password from employee where Email=? and Password=?";
					
					//Preparing statement to Execute............
					PreparedStatement st=conn.prepareStatement(query);
					st.setString(1,email);
					st.setString(2, password);
					
					// Prevent from going back when clicked on back button...............
					 response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
						response.setHeader("Pragma", "no-cache");
						response.setHeader("Expires", "0");
					
					// Getting number of executed field.............
					ResultSet rows=st.executeQuery();
					if(rows.next()){
						
						 HttpSession session=request.getSession();
						   session.setAttribute("email", email);
						   session.setAttribute("password", password);				
						   RequestDispatcher rd=request.getRequestDispatcher("Data");// Sending data in new class Data 
						rd.forward(request, response);
						
					}
					else{
						out.print("<html><head><body><script>alert('No such Data Found..Please Register Yourself');");
						out.println("location='Login.jsp';");
						out.print("</script></body></head></html>");
					
						
					}
					

				}catch(Exception e){
					e.printStackTrace();
					
				}
				
			} 
		   else{
			   
				
			   out.print("<html><head><body><script>alert('Invalid Email Address');");
				out.println("location='Login.jsp';");
				out.print("</script></body></head></html>");
				
			   
		   }
		   
		  
		}
		
		
		
		

}
