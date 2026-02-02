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
import models.Categories;
import models.Connector;

/**
 *
 * @author ad
 */
public class CategoryDAO {
    private Connection connect;
    
    public CategoryDAO() {
        this.connect = (Connection) Connector.getConnection();
    }
    
    public List<Categories> listCategory() {
        List<Categories> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories ORDER BY id DESC";
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Convert data to list object.
            while (rs.next()) {
                Categories category = new Categories();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                // Append object to array list
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
}
