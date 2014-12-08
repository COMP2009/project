<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id ="wrapper">
<img  src="eveninglogo.jpg" width="100" height="100">
<div id="head">


<h1>EVENING CLASSES</h1>
</div>
<div id="name"><p>Welcome, Please enter your details to sign in</p></div>
<%String error = (String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<div id="error">

<p><%=error %></p>

</div>
<%} %>

<div id="signin">
<form action="Validator" method="post">
User: <input type="text" name="uname"><br>
Password: <input type="password" name="pass"><br>

<button class="myButtonSubmit" type="submit" >SignIn</button>

</form>

<form action="signup.jsp" >
<button class = "myButtonSubmit" type="submit" >SignUp</button>
</form>
</div>
</div>
</body>
</html>