package com.eveningclasses.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eveningclasses.database.DummyDatabase;
import com.eveningclasses.domain.User;

/**
 * Servlet implementation class Home
 */
@WebServlet({"/home", "/login", "/register", "/logout"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DummyDatabase db= new DummyDatabase();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        db.initWithDefaultData();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath = request.getServletPath();

		System.out.println("get");
		
        String jsp = userPath.substring(1) + ".jsp";
        
		if(userPath.equals("/home")) {
			
		}
		
		if(userPath.equals("/register")) {
		}
		
		if(userPath.equals("/logout")) {
			request.getSession().setAttribute("user", null);
			jsp = "home.jsp";
		}


        // use RequestDispatcher to forward request internally
        try {
            request.getRequestDispatcher(jsp).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath = request.getServletPath();
		System.out.printf("post to %s\n", userPath);
		if(userPath.equals("/login")) {
			String username = request.getParameter("username");
	        String password = request.getParameter("password");
			System.out.printf("%s %s\n", username, password);
	        User user= db.getUserByUsername(username);
	        if(user != null) {
				System.out.println("found user in db");
	        	if(user.validatePassword(password)) {
	        		System.out.println("logged in");
	        		request.getSession().setAttribute("user", user);
	        	}
	        }
		} else if(userPath.equals("/register")) {
			String username = request.getParameter("username");
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String password = request.getParameter("password");
			System.out.printf("%s %s %s %s\n", username, firstName, lastName, password);
			User user= new User(username, firstName, lastName, password);
			db.createUser(user);
			request.getSession().setAttribute("user", user);
		}
		
        try {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

}
