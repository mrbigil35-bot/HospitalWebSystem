package com.hospital.controller;

import com.hospital.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        UserDAO userDao = new UserDAO();
        
        if (userDao.validateUser(user, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            
            response.sendRedirect("dashboard.jsp");
        } else {
            response.sendRedirect("index.jsp?error=Invalid Credentials");
        }
    }
}