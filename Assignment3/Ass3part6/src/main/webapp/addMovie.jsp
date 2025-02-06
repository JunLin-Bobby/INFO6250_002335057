<%-- 
    Document   : addMovie.jsp
    Created on : 2025年2月6日, 下午12:14:49
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
    <form action="AddMovieServlet" method="post">
        <label>Name：</label> <input type="text" name="title" required><br>
        <label>Actor：</label> <input type="text" name="actor" required><br>
        <label>Actress：</label> <input type="text" name="actress" required><br>
        <label>Genre：</label> <input type="text" name="genre" required><br>
        <label>Year：</label> <input type="number" name="year" required><br>
        <input type="submit" value="submit">
    </form>
    </body>
</html>
