/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ad
 */
public class Receipts {
    private int id;
    private int storage_id;
    private int category_id;
    private int total_price;
    private int quantity;
    private String note;
    private String delivery_date;
    private int type;
    private int user_id;
    private String image;
    private String name;
    private int logistics_provider_id;
    private int status;
    private String deleted_at;

    public Receipts() {
    }

    public Receipts(int id, int storage_id, int category_id, int total_price, int quantity, String note, String delivery_date, int type, int user_id, String image, String name, int logistics_provider_id, int status, String deleted_at) {
        this.id = id;
        this.storage_id = storage_id;
        this.category_id = category_id;
        this.total_price = total_price;
        this.quantity = quantity;
        this.note = note;
        this.delivery_date = delivery_date;
        this.type = type;
        this.user_id = user_id;
        this.image = image;
        this.name = name;
        this.logistics_provider_id = logistics_provider_id;
        this.status = status;
        this.deleted_at = deleted_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorage_id() {
        return storage_id;
    }

    public void setStorage_id(int storage_id) {
        this.storage_id = storage_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogistics_provider_id() {
        return logistics_provider_id;
    }

    public void setLogistics_provider_id(int logistics_provider_id) {
        this.logistics_provider_id = logistics_provider_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
}
