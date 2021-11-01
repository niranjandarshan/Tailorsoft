package com.niru;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Getting the required value from register.jsp
		String name=request.getParameter("name");
		String fathername=request.getParameter("fathername");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
	//Matching Email Pattern..............
		PrintWriter out=response.getWriter();
		String regex = "^(.+)@.(.+)$";  
		 Pattern pattern = Pattern.compile(regex);  
		  Matcher matcher = pattern.matcher(email);
				
		
		//Connection with database......
		Connection conn;
		
		  if(matcher.matches()){
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			String querycheck="select * from employee where Email='"+email+"'";
			PreparedStatement stm=conn.prepareStatement(querycheck);
			
			ResultSet rowstm=stm.executeQuery();
			
			//Checking if data is new or isAlready present in Database........
			if(rowstm.next()){
				out.print("<html><head><body><script>alert('Email already present');");
				out.println("location='Register.jsp';");
				out.print("</script></body></head></html>");

			}
			
			//Else inserting the new data value in Database.............
			else{
			String query="insert into employee(Name,Fathername,Gender,Phone,Email,Password)values(?,?,?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(query);
			st.setString(1,name);
			st.setString(2, fathername);
			st.setString(3, gender);
			st.setString(4, phone);
			st.setString(5, email);
			st.setString(6, password);
		
			
			int rows=st.executeUpdate();
			
			//Checking if data inserted Successfully...........
			
			if(rows>0){
				
				out.print("<html><head><body><script>alert('Data inserted successfully');");

				  HttpSession session=request.getSession();
				   session.setAttribute("email", email);
				   session.setAttribute("password", password);
				 
					out.println("location='Upload.jsp';");
					out.print("</script></body></head></html>");

			}
			//If not inserted............
			else{
				out.print("<html><head><body><script>alert('Error Occured');");
				out.println("location='Register.jsp';");
				out.print("</script></body></head></html>");

			}
			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		  //If EmailEntered by user is not valid..................
		  else{
				out.print("<html><head><body><script>alert('Email Format is wrong.');");
				out.println("location='Register.jsp';");
				out.print("</script></body></head></html>");


		  }
		
		
	}

}
