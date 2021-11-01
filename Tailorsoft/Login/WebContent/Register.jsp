<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="css/stylereg.css" rel="stylesheet" type="text/css"/>
        
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
</head>
<body>
<div align="center">
 <div class="container"align="center">
          
                <img class="avatar" src="img/collaboration.png">
                <h1>
Register Here</h1>
<form action="Register" method="post" >
         
                   <label>Name</label>
						<input type="text"  name="name" required><br/>
 					<label>Father's Name</label>
						<input type="text"  name="fathername" required><br/>
						
 					<label><b>Gender</b></label>
 					<label>Male</label>
					<input type="radio" value="male" name="gender" required>
 					<label>Female</label>
						<input type="radio" value="female" name="gender" required><br/>
					<label>Contact Number</label>
					<input type="text"  name="phone" required><br/>
					<label>Email Address</label>
						<input type="text"  name="email" required><br/>
                   <label>Password</label>
					<input type="password" name="password" required><br/>
					
	
				
	  			<input type="submit" value="Next"><br/>
                <a href="Login.jsp">Already User?</a>
               
					
					
                 
</form>

                
</div>

</div>

</body>
</html>