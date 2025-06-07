package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("SignupForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get form data sent from the browser
		String fname = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String un = request.getParameter("Username");
	    String password = request.getParameter("Password");
	    
	    // Basic null check (optional but safer)
	    if(fname == null || lastName == null || un == null || password == null) {
	    	request.setAttribute("message", "Please fill all fields.");
	    	request.getRequestDispatcher("SignupForm.jsp").forward(request, response);
	    	return;
	    }

	    // send user data in database
	    User u = new User();
	    u.setFname(fname);
	    u.setLname(lastName);
	    u.setUsername(un);
	    u.setPassword(password);
	    
	    UserService service = new UserServiceImpl();
	    service.signup(u);
	    
	    // Send that data to a JSP page for display
	    /*  # Store these values so the JSP can access them using ${...} syntax.
	    request.setAttribute("uname", un);
	    request.setAttribute("fname", fname);
	    request.setAttribute("lname", lastName);
	    request.setAttribute("psw", password);
	    */
	    
	    // request.getRequestDispatcher("Profile.jsp").forward(request, response); // leads to profile.jsp
	    request.getRequestDispatcher("LoginForm.jsp").forward(request, response); // leads to LoginForm.jsp
	}
}
