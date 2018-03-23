/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Magnus West Madsen
 */
public class Order {
    
    
    private int id;
    private int length;
    private int width;
    private int height;
    private int userId;
    private String status;

    public Order(int length, int width, int height, int userId) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
    }

    public Order(int id, int length, int width, int height, int userId, String status) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.userId = userId;
        this.status = status;
        
    }

    public String getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }
}
