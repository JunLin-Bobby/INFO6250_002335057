<%-- 
    Document   : shopping
    Created on : 2025年1月29日, 下午4:17:20
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>6250 Assignment2 part 7 Online store</title>
    </head>
    <body>
        <h2>Shop for Items</h2>

    <%
        // default "Book"
        String category = request.getParameter("category");
        if (category == null) {
            category = "books";
        }
    %>

    <!-- Catalog -->
    <div style="width: 200px; float: left;">
        <h3>Categories</h3>
        <ul>
            <li><a href="shopping.jsp?category=books">Books</a></li>
            <li><a href="shopping.jsp?category=computers">Computers</a></li>
        </ul>
    </div>

    <!-- Item List -->
    <div style="margin-left: 220px;">
        <h3>Available <%= category.substring(0, 1).toUpperCase() + category.substring(1) %></h3>
        
        <form action="shoppingcartservlet" method="post">
             <input type="hidden" name="action" value="add">
            <%
                if ("books".equals(category)) {
            %>
                <input type="checkbox" name="product" value="The Art of Computer Programming"> The Art of Computer Programming<br>
                <input type="checkbox" name="product" value="Clean Code"> Clean Code [$49.99]<br>
                <input type="checkbox" name="product" value="Introduction to Algorithms"> Introduction to Algorithms<br>
                <input type="checkbox" name="product" value="Effective Java"> Effective Java [$39.99]<br>
                <input type="checkbox" name="product" value="Design Patterns: Elements of Reusable Object-Oriented Software"> Design Patterns<br>
            <%
                } else if ("computers".equals(category)) {
            %>
                <input type="checkbox" name="product" value="Apple MacBook Pro with 13.3' Display"> Apple MacBook Pro with 13.3" Display<br>
                <input type="checkbox" name="product" value="Asus Laptop with Centrino 2 Black"> Asus Laptop with Centrino 2 Black<br>
                <input type="checkbox" name="product" value="HP Pavilion Laptop with Centrino 2 DV7"> HP Pavilion Laptop with Centrino 2 DV7<br>
                <input type="checkbox" name="product" value="Toshiba Satellite Laptop with Centrino 2 - Copper"> Toshiba Satellite Laptop with Centrino 2 - Copper<br>
                <input type="checkbox" name="product" value="Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink"> Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink<br>
            <%
                }
            %>

            <br>
            <input type="submit" value="Add to Cart">
        </form>
    </div>

    <!--  "View Cart" -->
    <div style="position: absolute; top: 10px; right: 10px;">
        <a href="cart.jsp">[ View Cart ]</a>
    </div>
    </body>
</html>
