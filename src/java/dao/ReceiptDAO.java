/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Connector;

/**
 *
 * @author ad
 */
public class ReceiptDAO {
    private Connection connect;
    
    public ReceiptDAO() {
        this.connect = (Connection) Connector.getConnection();
    }
    
    public boolean store(
            String receiptName, int categoryId, 
            String detail, String deliveryDate, int logisticProvider,
            int quantity, int totalPrice, int type, int storageId, int userId
    ) {
        String sql = "INSERT INTO receipts("
                + "name, storage_id, category_id, note, delivery_date, logistics_providers_id, "
                + "quantity, total_price, type, user_id "
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, receiptName);
            ps.setInt(2, storageId);
            ps.setInt(3, categoryId);
            ps.setString(4, detail);
            ps.setString(5, deliveryDate);
            ps.setInt(6, logisticProvider);
            ps.setInt(7, quantity);
            ps.setInt(8, totalPrice);
            ps.setInt(9, type);
            ps.setInt(10, userId);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
