package com.hospital.dao;

import com.hospital.model.Patient;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public boolean addPatient(Patient patient) {
        String sql = "INSERT INTO patients (name, age, gender, contact, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, patient.getName());
            pstmt.setInt(2, patient.getAge());
            pstmt.setString(3, patient.getGender());
            pstmt.setString(4, patient.getContact());
            pstmt.setString(5, patient.getAddress());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("contact"),
                    rs.getString("address")
                );
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}