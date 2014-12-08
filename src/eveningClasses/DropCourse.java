package eveningClasses;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DropCourse
 */
public class DropCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropCourse() {
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
		Course course = (Course)session.getAttribute("course");
		
		
		
		
		
		
		
		int count1=0;
		 Iterator<Student> item = home.data.students.iterator();
		 Student student1=null;
		 while(item.hasNext())
		 {
			student1=item.next();
			if(student1.getId()==studentid)
			{
				
				break;
			}count1++;
		 }
		 
		 List<Course> coursees = home.data.students.get(count1).getCourseList();
			Iterator<Course> c = coursees.iterator();
			while(c.hasNext())
			{
				Course c1 = c.next();
				System.out.print(c1.getCourseName());
			}
			System.out.println();
			 coursees = home.data.students.get(count1).getCourseListTemp();
			 c = coursees.iterator();
			while(c.hasNext())
			{
				Course c1 = c.next();
				System.out.print(c1.getCourseName());
			}
		
		
		
		
		
		
		
		
		
		
		
		
		 Iterator<Student> it = home.data.students.iterator();
		 Student student=null;
		 int count=0;
		 while(it.hasNext())
		 {
			student=it.next();
			if(student.getId()==studentid)
			{
				student.deleteCourse(course);
				
				break;
				
			}count++;
		 }
		 home.data.students.get(count).deleteCourse(course);
		 count1=0;
		  item = home.data.students.iterator();
		student1=null;
		 while(item.hasNext())
		 {
			student1=item.next();
			if(student1.getId()==studentid)
			{
				
				break;
			}count1++;
		 }
		 
		coursees = home.data.students.get(count1).getCourseList();
	 c = coursees.iterator();
			while(c.hasNext())
			{
				Course c1 = c.next();
				System.out.print(c1.getCourseName());
			}
			System.out.println();
			 coursees = home.data.students.get(count1).getCourseListTemp();
			 c = coursees.iterator();
			while(c.hasNext())
			{
				Course c1 = c.next();
				System.out.print(c1.getCourseName());
			}
		
		request.getRequestDispatcher("/temptimetable.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
