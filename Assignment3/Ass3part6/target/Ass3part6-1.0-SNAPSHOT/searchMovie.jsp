<%-- 
    Document   : BrowseMovie
    Created on : 2025年2月6日, 下午3:01:43
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
        <h1>Searching Movie</h1>

    <form action="SearchMovieServlet" method="get">
        <p>Choose Searching Type</p>
        <input type="radio" name="category" value="title" checked> Title
        <input type="radio" name="category" value="actor"> Actor
        <input type="radio" name="category" value="actress"> Actress
        <br><br>

        <label for="keyword">Keyword：</label>
        <input type="text" id="keyword" name="keyword" required>
        <br><br>

        <button type="submit">Search</button>
    </form>

    <br>
    <a href="index.jsp">Back to the main page</a>
    </body>
</html>
