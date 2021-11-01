package com.niru;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Upload
 */

@MultipartConfig

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Getting the session value...............
		HttpSession session=request.getSession();
		String email=  (String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		
		
		//Uploading AAdhar card.........
				Part file = request.getPart("aadhar");
				String imageFileNameaadhar=file.getSubmittedFileName();
				String uploadPath="D:\\Eclipse\\Tailorsoft\\Login\\WebContent\\Imagesaadhar\\"+imageFileNameaadhar;
				try{
				FileOutputStream fos= new FileOutputStream(uploadPath);
				InputStream is=file.getInputStream();
				
				byte[] data=new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
				
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
//				
				//Uploading Images Photo
				
				Part filephoto = request.getPart("photo");
				String imageFileNamephoto=filephoto.getSubmittedFileName();
				String uploadPathphoto="D:\\Eclipse\\Tailorsoft\\Login\\WebContent\\Images\\"+imageFileNamephoto;

				try{
				FileOutputStream fos= new FileOutputStream(uploadPathphoto);
				InputStream is=filephoto.getInputStream();
				
				byte[] data=new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
				
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
				PrintWriter out=response.getWriter();
				

				//Database Connectivity
				Connection conn;
				
				try{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","root");

					String query="update  employee set Photo='"+imageFileNamephoto +"' , Aadhar='"+imageFileNameaadhar+"' where Email= '"+email+"' and Password='"+password+"'";
					
					
					PreparedStatement st=conn.prepareStatement(query);
					
					
					int rows=st.executeUpdate();
					
					//Upload document in database
					if(rows>0){
//						
						out.print("<html><head><body><script>alert('Document updated successfully');");
						out.println("location='Login.jsp';");
						out.print("</script></body></head></html>");
					}
					else{
						out.print("<html><head><body><script>alert('Failed to Upload Try later');");
						out.println("location='Upload.jsp';");
						out.print("</script></body></head></html>");
					}
					
				}catch(Exception e){
					e.printStackTrace();
					}
				
			
	}

}
                                              