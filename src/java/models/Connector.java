/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dang dinh duc
 */
public class Connector {
    public static Connection getConnection() {
        Connection connect = null;
        try {
            // Begin connect database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nencer_jsc",
                "root",
                ""
            );
            System.out.println("Connect database success");
            return connect;
        }
        catch(Exception e) {
            System.out.println("Connect database failed");
            e.printStackTrace();
            return null;
        }
    }
}
