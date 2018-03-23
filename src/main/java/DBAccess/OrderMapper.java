/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.UniversalException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magnus West Madsen
 */
public class OrderMapper {
    
    public static boolean createOrder(Order order) throws UniversalException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (length, width, height, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getLength());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getHeight());
            ps.setInt(4, order.getUserId());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UniversalException(ex.getMessage());
        }
    }

    public static List<Order> getUsersOrders(User user) throws UniversalException {
        List<Order> orders = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int userId = rs.getInt("user_id");
                String status = rs.getString("status");
                orders.add(new Order(id, length, width, height, userId, status));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UniversalException(ex.getMessage());
        }
        return orders;
    }

    public static List<Order> getAllOrders() throws UniversalException {
        List<Order> orders = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int userId = rs.getInt("user_id");
                String status = rs.getString("status");
                orders.add(new Order(id, length, width, height, userId, status));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UniversalException(ex.getMessage());
        }
        return orders;
    }

    public static boolean updateStatus(int orderId) throws UniversalException {
        boolean changedLines;
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET status='Sent' WHERE id= ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            changedLines = ps.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UniversalException(ex.getMessage());
        }
        return changedLines;
    }
}
