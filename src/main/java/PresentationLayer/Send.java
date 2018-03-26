/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.BrickCal;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.UniversalException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Magnus West Madsen
 */
public class Send extends Command{
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalException {
        
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        boolean success = LogicFacade.updateStatus(orderId);
        
        List<Order> orders = LogicFacade.getAllOrders();
        for(Order o : orders){
            BrickCal.calcualt(o);
        }
        session.setAttribute("allOrders", orders);
        
        if (success) {
            return "employeeorderpage";
        } else {
            throw new UniversalException("Failed to send");
        }
    }
}
