<%-- 
    Document   : addMovie
    Created on : 2025年2月17日, 下午4:46:31
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h2>Add new Movie</h2>
        <form action="movie.htm" method="post">
<!--            hidden url-->
            <input type="hidden" name="action" value="addMovieSubmit">
            <label>Name：</label> <input type="text" name="title" required><br>
            <label>Actor：</label> <input type="text" name="actor" required><br>
            <label>Actress：</label> <input type="text" name="actress" required><br>
            <label>Genre：</label> <input type="text" name="genre" required><br>
            <label>Year：</label> <input type="number" name="year" required><br>
            <input type="submit" value="submit">
        </form>
        <br>
        <p style="color: green;">${message}</p>
        <a href="home.htm">Back to Home</a>
    </body>
</html>
