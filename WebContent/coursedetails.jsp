<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import=" eveningClasses.*"%>
    
<%@ page import= "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
<img  src="eveninglogo.jpg" width="100" height="100">
<div id="head">
<h1> EVENING CLASSES</h1>
</div>
<div id="name">
<p>Welcome,<%=session.getAttribute("user") %></p>
</div>
<%   List<Student> studeents = home.data.students;
Iterator<Student> it = studeents.iterator();
Student user=null;
		        while (it.hasNext()) {
		            user = it.next();
		            if (user.getId()==(Integer)session.getAttribute("studentid")) 
		            	break;
		        }
List<Course> courseList = new ArrayList<Course>(user.getCourseList()); %>
<div id="test">
<h3>My courses</h3>
<% List<Course> coursesList = home.data.courses;
List <Course> otherCourses = new ArrayList<Course>();
Iterator<Course> iter = coursesList.iterator();
while(iter.hasNext())
{
	Course course = iter.next();
	if(courseList.contains(course))
	{%>
<a href="CourseDetails?value=<%=course.getId()%>" class="myButtonCourse">
      <%=course.getCourseName() %></a>
    <br>
<% 		
	}
	else
	{
		otherCourses.add(course);
	}}
%>	

<h3>Courses available</h3>
<%Iterator<Course> itera = otherCourses.iterator();
while(itera.hasNext())
{
	Course course = itera.next();
	%>
	<a href="CourseDetails?value=<%=course.getId()%>" class="myButtonCourse">
      <%=course.getCourseName() %></a>
      <br>
	<%
	}%></div>      

<div id="coursedetails">
<%Course course = (Course)session.getAttribute("course"); %>
<h2>Course00 <%=course.getId()%> : <%=course.getCourseName() %></h2>
<p><%=course.getDay() %></p>
<p><%=course.getTime() %></p>
<% Student student=null;
Iterator<Student> item = home.data.students.iterator();
while (item.hasNext()) {
    student = item.next();
    if (student.getId()==(Integer)session.getAttribute("studentid")) 
    	break;
}
List<Course> courses = student.getCourseList();
if(courses.contains(course))
{%>
<a href="DropCourse">
      <button class="myButtonSubmit">Drop </button></a>
<%} else {%>
<a href="AddCourse">
      <button class="myButtonSubmit">Add  </button></a>
      <%} %>
      </div>
      </div>
</body>
</html>