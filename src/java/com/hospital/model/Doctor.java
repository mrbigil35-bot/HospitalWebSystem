package com.hospital.model;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialty;

    // Default Constructor
    public Doctor() {
    }

    // Constructor without ID (used when adding a new doctor)
    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    // Constructor with ID (used when retrieving from the database)
    public Doctor(int doctorId, String name, String specialty) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
    }

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}