<%-- 
    Document   : index.jsp
    Created on : 2025年2月7日, 下午8:25:11
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Please enter how many books you want to add.</h2>
        <form action="AddBooksServlet" method="GET">
        <label for="bookCount">Numbers:</label>
        <input type="number" name="bookCount" min="1" required>
        <button type="submit">submit</button>
    </form>
    </body>
</html>
