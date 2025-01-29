<%-- 
    Document   : login
    Created on : 2025年1月29日, 下午6:28:48
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>

   
    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
        <p style="color:red;">Invalid username or password. Please try again.</p>
    <%
        }
    %>

    <form action="loginservlet" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <p>default username:user, ps:123 </p>
    </body>
</html>
