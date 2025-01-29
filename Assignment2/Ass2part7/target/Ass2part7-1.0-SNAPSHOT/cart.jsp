<%-- 
    Document   : cart
    Created on : 2025年1月29日, 下午6:06:08
    Author     : bobby
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--***Login Checking***-->
<%
    
    String username = (String) session.getAttribute("username");
    if (username == null) {
        
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
          <h2>Your Shopping Cart</h2>

    <%
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
    %>
        <p>Your cart is empty.</p>
    <%
        } else {
    %>
        <ul>
        <%
            for (String item : cart) {
        %>
            <li>
                <%= item %> 
                 <a href="shoppingcartservlet?action=remove&remove=<%= item %>">[Remove]</a>
            </li>
        <%
            }
        %>
        </ul>
    <%
        }
    %>

    <br>
    <a href="shopping.jsp">Continue Shopping</a>
    </body>
</html>
