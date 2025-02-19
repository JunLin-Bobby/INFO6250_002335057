<%-- 
    Document   : home
    Created on : 2025年2月17日, 下午4:31:35
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome to Movie Store!</h1>
        <form action="home.htm" method="post">
            <label for="action">Please select...</label>
            <select name="action">
                <option value="addMovie">Add movies</option>
                <option value="searchMovie">Search movies</option>
            </select>
            <button type="submit">submit</button>
        </form>
    </body>
</html>
