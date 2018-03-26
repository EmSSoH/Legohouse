<%-- 
    Document   : employeeorderpage
    Created on : 26-03-2018, 19:06:23
    Author     : Magnus West Madsen
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Order> orders = (ArrayList<Order>) session.getAttribute("allOrders");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Order page</title>
    </head>
    <body>
        
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        Here is Emloyee order page
     
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
            <td>
                <form action="FrontController" method="POST">
                    <input type="hidden" name="command" value="send">
                    <input type="hidden" name="orderId" value="<%out.print(o.getId());%>">
                    <%if (o.getStatus().equals("Not sent")) {%>
                    <input type="submit" value="Mark as sent">
                    <%}%>
                </form>
            </td>
            
        </tr>
        <%}%>
    </table>
    
    
</div>
        
    </body>
</html>