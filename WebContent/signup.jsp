<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup</title>
</head>
<body>
<div id ="wrapper">
<img  src="eveninglogo.jpg" width="100" height="100">
<div id="head">


<h1>EVENING CLASSES</h1>
</div>

<div id="name"><p>Welcome, Please enter your details to register</p></div>
<div id="signin">
<form action="Validator1" method="post">
First Name: <input type="text" name="fname"><br>
Last Name: <input type="text" name="lname"><br>
User Name: <input type="text" name="uname"><br>
Password: <input type="password" name="pass"><br>

<button type="submit" class="myButtonSubmit" >Submit</button>

</form>
</div>
</div>
</body>
</html>