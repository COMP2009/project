package eveningClasses;

import java.io.IOException;

import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validator
 */
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname= request.getParameter("uname");
		String pass = request.getParameter("pass");
		String error = "NA";
				Iterator<Student> it = home.data.students.iterator();
		        while (it.hasNext()) {
		            Student user = it.next();
		            if (user.getUname().equals(uname)) {
		            	
		                if(user.getPass().equals(pass))
		                {
		                	HttpSession session = request.getSession();
		                	session.setAttribute("user",uname);
		                	int id = user.getId();
		            		session.setAttribute("studentid",id );
		            		session.setAttribute("student", user);
		                	request.getRequestDispatcher("/timetable.jsp").forward(request,response);
		                	return;
		                }
		                else
		                {
		                	error = "You have entered the wrong password";		                	
		             
		                }
		                	
		            }
		        }
		        if(error.equals("NA"))
		        error = "You are not registered, please sign up";
            	request.setAttribute("error", error);
            	request.getRequestDispatcher("/home.jsp").forward(request,response);
		        
	}

}
