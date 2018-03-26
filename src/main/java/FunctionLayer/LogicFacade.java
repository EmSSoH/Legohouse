package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws UniversalException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws UniversalException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    
    public static boolean newOrder(Order order) throws UniversalException {
        return OrderMapper.createOrder(order);
    }

    public static List<Order> getUsersOrders(User user) throws UniversalException {
        return OrderMapper.getUsersOrders(user);
    }

    public static List<Order> getAllOrders() throws UniversalException {
        return OrderMapper.getAllOrders();
    }

    public static boolean updateStatus(int orderId) throws UniversalException {
        boolean success = OrderMapper.updateStatus(orderId);
        return success;
    }
    
    
    public static void BrickCal(Order order) throws UniversalException {
        BrickCal.calcualt(order);
    }
}
