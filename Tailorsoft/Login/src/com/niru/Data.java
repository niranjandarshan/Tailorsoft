package com.niru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Data
 */
@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//Getting session value in email and password...................
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		
		
		PrintWriter out=response.getWriter();
		
		
		//Database Connectivity
		Connection conn;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");
			String query="select *  from employee where Email='"+email+"' and Password='"+password+"'";
			
			PreparedStatement st=conn.prepareStatement(query);
			ResultSet rows=st.executeQuery();
			//Retriving all the data/..................
			while(rows.next()){
				out.print("<html><body><div align='center'><a href='Logout'>Logout>></a><h1>Feeded informations </h1><table  border='5px' cellpadding='5px' cellspacing='5px'><th>Id</th><th>Name</th><th>Father Name</th><th>Gender</th><th>Phone</th><th>Email</th><th>Aadhar</th><th>Images</th>");
				out.print("<tr><td>");
				out.print(rows.getInt(1)); 	//Id
				out.print("</td>");
				out.print("<td>");
				out.print(rows.getString(2));	// Name
				out.print("</td>");
				out.print("<td>");
				out.print(rows.getString(3));	//Father Name
				out.print("</td>");
				out.print("<td>");
				out.print(rows.getString(4));	//Gender
				out.print("</td>");
				out.print("<td>");
				out.print(rows.getString(5));	//Phone
				out.print("</td>");
				out.print("<td>");
				out.print(rows.getString(6));	//Email
				out.print("</td>");

				out.print("<td>");
				out.print("<img src='Imagesaadhar/"+rows.getString(8)+"'width='150px' height='150px'/>"); 	//AAdhar
			
				out.print("</td>");

				out.print("<td>");
				out.print("<img src='Images/"+rows.getString(9)+"' width='200px' height='200px'/>");	//Images
				out.print("</td></tr></table></div></body></html>");
				





				
			}
		}catch(Exception e){
			
		}
		
	}

}
