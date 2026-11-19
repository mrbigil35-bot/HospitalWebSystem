package com.hospital.dao;

import com.hospital.util.DBConnection;
import java.sql.*;

public class UserDAO {

    // Existing login validation method
    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // NEW METHOD: Register a new user
    public boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            return pstmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Registration fails if username already exists (if constrained) or DB error occurs
        }
    }
}