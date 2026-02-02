/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ad
 */
public class User {
    private int id;
    private String email;
    private String password;
    private int role;
    private int storage_id;
    private String deleted_at;
    
    // Define global static constant
    public static int ROLE_EMPLOYEE = 0;

    public User() {
    }    

    public User(int id, String email, String password, int role, int storage_id, String deleted_at) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.storage_id = storage_id;
        this.deleted_at = deleted_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStorage_id() {
        return storage_id;
    }

    public void setStorage_id(int storage_id) {
        this.storage_id = storage_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
}
