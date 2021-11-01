<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
        <link href="css/stylereg.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div align="center">
 <div class="container"align="center">
<div align='center' background-color=' yellow' border='3px solid blue'>
	<h1 align='center' color='red'>Upload Documents</h1>
	<br/>
	<form action="UploadServlet" method='post' enctype='multipart/form-data'>
	
	<label><b>1. Upload Your Photo</b></label>
	<input type="file" name='photo' size="50" required>
	<br/><br/>
		<label><b>2. Upload Your AAdhar card</b></label>
	
	<input type="file" name='aadhar' size="50" required>
	<br/><br/>
	<input type='submit' name='submit' value='Submit Document'>
	</form>
	</div>
	</div>
	</div>
</body>
</html>