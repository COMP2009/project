package eveningClasses;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCourse
 */
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int studentid = (Integer) session.getAttribute("studentid");
		Course courses = (Course)session.getAttribute("course");
		 Iterator<Student> it = home.data.students.iterator();
		 int count=0;
		 Student student=null;
		 while(it.hasNext())
		 {
			student=it.next();
			if(student.getId()==studentid)
			{
				
				break;
			}count++;
		 }
		 
		 Iterator<Course> item = home.data.courses.iterator();
		 int counter=0;
		 
		 Course course;
		while(item.hasNext())
		 {
			course=item.next();
			if(course.getId()==courses.getId())
			{
				
				break;
			}counter++;
		 }
		 
		 if((!( home.data.students.get(count).isEnrolled(courses)) && (!home.data.courses.get(counter).isFull())  ) )
		 {
		 home.data.students.get(count).setEnrolled(courses);
		 Student add = home.data.students.get(count);
		 home.data.courses.get(counter).addStudent(add);
		
		 request.getRequestDispatcher("/temptimetable.jsp").forward(request,response);
		 }
		 else{
			 
			  String full="full";
			 request.setAttribute("full", full);
			 request.getRequestDispatcher("/timetable.jsp").forward(request,response);
			 
		 }
			 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
