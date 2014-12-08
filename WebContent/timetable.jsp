<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import=" eveningClasses.*"%>
    
<%@ page import= "java.util.*"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Timetable</title>
</head>
<body>
<div id ="wrapper">
<img  src="eveninglogo.jpg" width="100" height="100">
<div id="head">
<h1>EVENING CLASSES</h1>
</div>
<div id="name">
<p>Welcome,<%=session.getAttribute("user") %></p>
</div>
<% Course classes[][][] = new Course[6][7][3];
   int count[][] = new int[6][7];
   List<Student> studeents = home.data.students;
 Iterator<Student> it = studeents.iterator();
 Student user=null;
		        while (it.hasNext()) {
		            user = it.next();
		            if (user.getId()==(Integer)session.getAttribute("studentid")) 
		            	break;
		        }
 List<Course> courseList = new ArrayList<Course>(user.getCourseList());
 Iterator<Course> i = courseList.iterator();
 while(i.hasNext())
 {
	Course course = i.next();
	String day = course.getDay();
	int time = course.getTime();
	time/=100;
	time-=16;
	if(day.equals("Monday"))
		classes[time][0][count[time][0]++] = course;
	else if(day.equals("Tuesday"))
		classes[time][1][count[time][1]++] = course;
	else if(day.equals("Wednesday"))
		classes[time][2][count[time][2]++] = course;
	else if(day.equals("Thursday"))
		classes[time][3][count[time][3]++] = course;
	else if(day.equals("Friday"))
		classes[time][4][count[time][4]++] = course;
	else if(day.equals("Saturday"))
		classes[time][5][count[time][5]++] = course;
	else if(day.equals("Sunday"))
		classes[time][6][count[time][6]++] = course;
 }
	
 
		        
		       	        %>
		       	        
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

<div class="CSSTableGenerator">	 	     
<table width=80%>
<tr><td>Time</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td><td>Sun</td></tr>

<% for(int m=0; m<6; m++){   %>
  <tr><td><%=(m+16)*100 %></td>
  <% for(int n=0; n<7; n++){ %><td bgcolor="#DF0101">  
    <% for(int l=0; l< count[m][n];l++){ %> 
    
      <a href="CourseDetails?value=<%=classes[m][n][l].getId()%>" class="myButton">
      
      <%=classes[m][n][l].getCourseName() %></a>
      <p></p>
      <%} %>
      </td><%} %>
      </tr><%} %>

</table>
</div>
   

	</div>
</body>
</html>