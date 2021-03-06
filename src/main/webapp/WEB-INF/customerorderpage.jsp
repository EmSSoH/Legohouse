<%-- 
    Document   : customerorderpage
    Created on : 23-03-2018, 00:10:26
    Author     : Magnus West Madsen
--%>
<%@page import="FunctionLayer.Order"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Order> orders = (ArrayList<Order>) session.getAttribute("orders");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Order page</title>
    </head>
    <body>
        
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        Here is your order page
     
    <table  align="center">
        <tr>
            <th>Id</th>
            <th>Length</th>
            <th>Width</th>
            <th>Height</th>
            <th>2x4 brick</th>
            <th>2x2 brick</th>
            <th>2x1 brick</th>
            <th>Status</th>
        </tr>
        <%for (Order o : orders) {%>
        <tr>
            <td><%out.print(o.getId());%></td>
            <td><%out.print(o.getLength());%></td>
            <td><%out.print(o.getWidth());%></td>
            <td><%out.print(o.getHeight());%></td>
            <td><%out.print(o.getBrick4() + "x [::::]");%></td>
            <td><%out.print(o.getBrick2() + "x [::]");%></td>
            <td><%out.print(o.getBrick1() + "x [:]");%></td>
            <td><%out.print(o.getStatus());%></td>
            
        </tr>
        <%}%>
    </table>
    
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="keepShopping">
        <input type="submit" value="Keep shoping">
    </form>
</div>
        
    </body>
</html>
