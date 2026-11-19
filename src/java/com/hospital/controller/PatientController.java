package com.hospital.controller;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PatientController extends HttpServlet {
    private PatientDAO dao;

    @Override
    public void init() {
        dao = new PatientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        if (action.equals("list")) {
            List<Patient> patients = dao.getAllPatients();
            request.setAttribute("patientList", patients); 
            request.getRequestDispatcher("patients.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("insert".equals(action)) {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");
            
            Patient newPatient = new Patient(name, age, gender, contact, address);
            
            dao.addPatient(newPatient);
            
            response.sendRedirect("PatientController?action=list");
        }
    }
}