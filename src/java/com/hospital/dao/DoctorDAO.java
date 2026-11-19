package com.hospital.dao;

import com.hospital.model.Doctor;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public boolean addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (name, specialty) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSpecialty());
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Doctor d = new Doctor(
                    rs.getInt("doctor_id"),
                    rs.getString("name"),
                    rs.getString("specialty")
                );
                doctors.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}