package com.hospital.controller;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DoctorController extends HttpServlet {
    private DoctorDAO doctorDAO;

    @Override
    public void init() {
        doctorDAO = new DoctorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        List<Doctor> doctors = doctorDAO.getAllDoctors();
        request.setAttribute("doctorList", doctors);
        request.getRequestDispatcher("doctors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("insert".equals(action)) {
            String name = request.getParameter("name");
            String specialty = request.getParameter("specialty");
            
            Doctor newDoctor = new Doctor(name, specialty);
            doctorDAO.addDoctor(newDoctor);
            
            response.sendRedirect("DoctorController");
        }
    }
}