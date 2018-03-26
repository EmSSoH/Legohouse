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
    private int brick1;
    private int brick2;
    private int brick4;

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

    public int getBrick1() {
        return brick1;
    }

    public int getBrick2() {
        return brick2;
    }

    public int getBrick4() {
        return brick4;
    }

    public void setBrick1(int brick1) {
        this.brick1 = brick1;
    }

    public void setBrick2(int brick2) {
        this.brick2 = brick2;
    }

    public void setBrick4(int brick4) {
        this.brick4 = brick4;
    }
    
    
}
