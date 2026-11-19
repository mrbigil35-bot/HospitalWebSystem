package com.hospital.controller;

import com.hospital.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        UserDAO userDao = new UserDAO();
        
        // Attempt to register the user in the database
        if (userDao.registerUser(user, pass)) {
            // Redirect back to login page with a success message
            response.sendRedirect("index.jsp?msg=Registration Successful! Please login.");
        } else {
            // Redirect back to registration page if it fails
            response.sendRedirect("register.jsp?error=Registration Failed. Please try again.");
        }
    }
}