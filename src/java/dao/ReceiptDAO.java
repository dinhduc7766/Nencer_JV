/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Connector;
import models.LogisticsProviders;
import models.Receipts;

/**
 *
 * @author ad
 */
public class ReceiptDAO {
    private Connection connect;
    
    public ReceiptDAO() {
        this.connect = (Connection) Connector.getConnection();
    }
    
    public List<Receipts> list(String id, String category, String from_date, String to_date) {
        List<Receipts> receipts = new ArrayList<>();
        String sql = "SELECT "
                + "receipts.id,  receipts.name, receipts.note, receipts.delivery_date, "
                + "receipts.total_price, receipts.image, "
                + "categories.name as category_name, "
                + "logistics_providers.name as logistics_providers_name "
                + "FROM receipts "
                + "INNER JOIN categories ON receipts.category_id = categories.id  "
                + "INNER JOIN logistics_providers ON logistics_providers.id = receipts.logistics_providers_id "
                + "WHERE deleted_at IS NULL ";
                if (id != null && !id.equals("")) {
                    sql = sql + "AND receipts.id = "+id+" " ;
                }
                if (category != null && !category.equals("")) {
                    sql = sql + "AND receipts.category_id = "+category+" ";
                }
                if (from_date != null && to_date != null && !from_date.equals("") && !to_date.equals("")) {
                    sql = sql + "AND receipts.created_at BETWEEN "+from_date+" AND "+to_date+" ";
                }
                sql = sql + "ORDER BY id DESC";
//                System.out.println(sql);
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Convert data to list object.
            while (rs.next()) {
                Receipts receipt = new Receipts();
                receipt.setId(rs.getInt("id"));
                receipt.setName(rs.getString("name"));
                receipt.setCategory_name(rs.getString("category_name"));
                receipt.setNote(rs.getString("note"));
                receipt.setDelivery_date(rs.getString("delivery_date"));
                receipt.setTotal_price(rs.getInt("total_price"));
                receipt.setImage(rs.getString("image"));
                receipt.setLogistics_providers_name(rs.getString("logistics_providers_name"));
                receipts.add(receipt);
            }
            return receipts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
