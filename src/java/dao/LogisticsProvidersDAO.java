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
import models.LogisticsProviders;

/**
 *
 * @author ad
 */
public class LogisticsProvidersDAO {
    private Connection connect;
    
    public LogisticsProvidersDAO() {
        this.connect = (Connection) Connector.getConnection();
    }
    
    public List<LogisticsProviders> listProvider() {
        List<LogisticsProviders> logisticsProviders = new ArrayList<>();
        String sql = "SELECT * FROM logistics_providers ORDER BY id DESC";
        try {
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Convert data to list object.
            while (rs.next()) {
                LogisticsProviders providers = new LogisticsProviders();
                providers.setId(rs.getInt("id"));
                providers.setName(rs.getString("name"));
                // Append object to array list
                logisticsProviders.add(providers);
            }
            return logisticsProviders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
