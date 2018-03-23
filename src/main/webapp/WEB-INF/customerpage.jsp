<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        You are now logged in as a customer of our wonderful site.
        
        </div>
    <form action="FrontController" name="shop" method="POST">
        <input type="hidden" name="command" value="shop">
        <div>
            <label for="len>"Length>Length</label>
            <input type="number"  id="len" name="length" value="5" min="5">
        </div>
        <div>
            <label for="wid>"Length>Width</label>
            <input type="number"  id="wid" name="width" value="5" min="5">
        </div>
        <div>
            <label for="hei>"Length>Height</label>
            <input type="number"  id="hei" name="height" value="1" min="1">
        </div>
        <input type="submit"  value="Submit">
    </form>
        <form action="FrontController" name="getOrder" method="POST">
            <input type="hidden" name="command" value="getOrder">
            <input type="submit" value="Submit">
        </form>
            
               
</div>
        
        <% String added = (String) request.getAttribute( "added");
           if ( added != null) { %>
           <H2>Attention!!</h2>
           <p><%= added %>
        <% }
        %>

    </body>
</html>
