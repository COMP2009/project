<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
        <link href="css/jquery-ui.min.css" rel="stylesheet">
    <link href="css/fullcalendar.css" rel="stylesheet">
    
    <link href="css/eveningclasses.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Evening Classes</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">Book</a></li>
            <li><a href="#contact">Manage</a></li>
          </ul>
                  
          <form action="login" class="navbar-form navbar-right" role="form" method="post"}>
          
          	<c:if test="${user eq null }">
            <div class="form-group">
              <input type="text" name="username" placeholder="Username" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" name="submit" value="login" class="btn btn-success">Sign in</button>  
            
          	</c:if>
          	<a class="btn btn-default" href=${user eq null ? "register" : "logout"}>${user eq null ? "Register" : "Logout"}</a>       
          </form>
          <c:if test="${user ne null }">
          <div class="navbar-right">  
            <ul class="nav navbar-nav">           
            	<li><a href="#profile">${user.firstName} ${user.lastName}
          	<span class="glyphicon glyphicon-user"></span>   </a></li>
          	</ul>     
          </div>
          </c:if>
        </div><!--/.nav-collapse -->

      </div>
    </nav>

    <div class="container">
      <div class="starter-template">
        <h1>Evening Classes Booking and Management</h1>
      </div>
      <div class="row">
      	  <div class="col-md-4">
	      		<p> Classes </p>
	      </div>
	      <div class="col-md-8">
	      		<div id="calendar"></div>
	      </div>
	  </div>
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>
  	<script src="js/timetable.js"></script>
</body></html>
