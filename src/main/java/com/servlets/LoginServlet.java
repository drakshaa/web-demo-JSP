package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;
import com.service.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    // Optional: If someone tries to use GET, redirect to login form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("LoginForm.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String un = request.getParameter("username");
        String psw = request.getParameter("password");
        
        UserService service = new UserServiceImpl();
         
        if(service.login(un, psw)) {
        	// send data from servlet to jsp
        	 request.setAttribute("uname", un);
             request.getRequestDispatcher("Home.jsp").forward(request, response);
         } else {
             request.setAttribute("message", "User not found!");
             request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
         } 
         
        /* if ("hari".equals(un) && "123".equals(psw)) {
            request.setAttribute("uname", un);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "User not found!");
            request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
        } */
        	 
    }
}
// send and print signup data to profile.jsp
// signup ma click garyo bhane signup servlet bata form khulnu paryo
// make signup page and when click button data should (un, pass) should come in signup servlet ko do post
// show the data entered in signup to profile