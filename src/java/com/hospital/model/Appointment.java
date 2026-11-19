package com.hospital.model;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    
    // Extra fields to display names in the JSP instead of just IDs
    private String patientName; 
    private String doctorName;

    public Appointment() {}

    // Constructor for inserting a new appointment
    public Appointment(int patientId, int doctorId, String appointmentDate) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    // Constructor for retrieving from the database with JOINs
    public Appointment(int appointmentId, int patientId, int doctorId, String appointmentDate, String patientName, String doctorName) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    // Getters and Setters
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
}
