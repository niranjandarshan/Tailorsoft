<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
 <div class="container">
            <div class="regbox box">
                <img class="avatar" src="img/collaboration.png">
                <h1>
Login Here</h1>
<form action="Login" method="post">
         
                   <label>Email id</label>
<input type="text" placeholder="Useremail" name="email" required>
                   <label>Password</label>
<input type="password" placeholder="Password" name="password" required>
                   <input type="submit" value="Login">
                   <a href="Register.jsp">I am New User?</a>
                </form>
</div>
</div>

</body>
</html>