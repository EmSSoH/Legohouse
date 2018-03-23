/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.UniversalException;
import FunctionLayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FunctionLayer.Order;

/**
 *
 * @author Magnus West Madsen
 */

    public class Shop extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Order order = new Order(length, width, height, user.getId());
        boolean added = LogicFacade.newOrder(order);
        session.setAttribute("added", "your order have been added");
        if (!added) {
            throw new UniversalException("Could not add order");
        } else {
            return "customerpage";
        }
    }
}
