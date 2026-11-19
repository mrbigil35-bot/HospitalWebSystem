package com.hospital.controller;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.PatientDAO;
import com.hospital.model.Appointment;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AppointmentController extends HttpServlet {
    private AppointmentDAO appointmentDAO;
    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;

    @Override
    public void init() {
        appointmentDAO = new AppointmentDAO();
        patientDAO = new PatientDAO();
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

        request.setAttribute("appointmentList", appointmentDAO.getAllAppointments());
        request.setAttribute("patientList", patientDAO.getAllPatients());
        request.setAttribute("doctorList", doctorDAO.getAllDoctors());
        
        request.getRequestDispatcher("appointments.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("insert".equals(action)) {
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            String appointmentDate = request.getParameter("appointmentDate");
            
            Appointment newAppt = new Appointment(patientId, doctorId, appointmentDate);
            appointmentDAO.addAppointment(newAppt);
            
            response.sendRedirect("AppointmentController");
        }
    }
}