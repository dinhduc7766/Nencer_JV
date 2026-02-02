/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import models.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.User;

/**
 *
 * @author ad
 */
public class UserDAO {
    private Connection connect;
    
    public UserDAO() {
        this.connect = (Connection) Connector.getConnection();
    }
    
    public boolean verifyAccount(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND deleted_at IS NULL";
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Check role
                int role = rs.getInt("role");
                if (role == User.ROLE_EMPLOYEE) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public User findByEmail(String email) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setStorage_id(rs.getInt("storage_id"));
                user.setRole(rs.getInt("role"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
