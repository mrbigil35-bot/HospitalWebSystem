package com.hospital.model;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String contact;
    private String address;

    public Patient() {}

    // Constructor without ID (for inserts)
    public Patient(String name, int age, String gender, String contact, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
    }

    // Constructor with ID (for reading from DB)
    public Patient(int patientId, String name, int age, String gender, String contact, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}