package com.eveningclasses.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eveningclasses.database.DummyDatabase;
import com.eveningclasses.domain.FullCalendarEvent;
import com.eveningclasses.domain.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class Home
 */
@WebServlet({"/home", "/login", "/register", "/logout", "/events"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DummyDatabase db= new DummyDatabase();
       
    /**c
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        db.initWithDefaultData();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPath = request.getServletPath();
		System.out.printf("get to %s\n", userPath);
		
        String jsp = userPath.substring(1) + ".jsp";
        
		if(userPath.equals("/home")) {
			
		} else if(userPath.equals("/register")) {
		
		} else if(userPath.equals("/events")) {
			System.out.println("events");
			List<FullCalendarEvent> eventList = new ArrayList<>();

		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		    String start = df.format(new Date());
		    Date later = new Date();
		    later.setHours(5);
		    String end = df.format(later);
		    
			eventList.add(new FullCalendarEvent("example event", start, end, false, "#123"));
            String json = new Gson().toJson(eventList);
            System.out.println("json value " + json);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return;
		} else if(userPath.equals("/logout")) {
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
