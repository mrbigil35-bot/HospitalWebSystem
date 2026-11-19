package com.hospital.dao;

import com.hospital.model.Appointment;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public boolean addAppointment(Appointment appt) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, appt.getPatientId());
            pstmt.setInt(2, appt.getDoctorId());
            pstmt.setString(3, appt.getAppointmentDate());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        // Using SQL JOIN to get the actual names of the patient and doctor
        String sql = "SELECT a.appointment_id, a.patient_id, a.doctor_id, a.appointment_date, " +
                     "p.name AS patient_name, d.name AS doctor_name " +
                     "FROM appointments a " +
                     "JOIN patients p ON a.patient_id = p.patient_id " +
                     "JOIN doctors d ON a.doctor_id = d.doctor_id";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Appointment appt = new Appointment(
                    rs.getInt("appointment_id"),
                    rs.getInt("patient_id"),
                    rs.getInt("doctor_id"),
                    rs.getString("appointment_date"),
                    rs.getString("patient_name"),
                    rs.getString("doctor_name")
                );
                appointments.add(appt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}