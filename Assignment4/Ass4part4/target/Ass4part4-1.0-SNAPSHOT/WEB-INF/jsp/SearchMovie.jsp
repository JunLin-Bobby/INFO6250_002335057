<%-- 
    Document   : SearchMovie
    Created on : 2025年2月18日, 下午9:39:36
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

    <form action="movie.htm" method="post">
        <p>Choose Searching Type</p>
        <input type="hidden" name="action" value="searchMovieSubmit">
        <input type="radio" name="category" value="title" checked> Title
        <input type="radio" name="category" value="actor"> Actor
        <input type="radio" name="category" value="actress"> Actress
        <br><br>

        <label for="keyword">Keyword：</label>
        <input type="text" id="keyword" name="keyword" required>
        <br><br>

        <button type="submit">Search</button>
    </form>
    </body>
</html>
