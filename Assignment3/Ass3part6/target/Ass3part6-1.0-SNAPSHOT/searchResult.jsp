<%-- 
    Document   : searchResult
    Created on : 2025年2月6日, 下午3:11:44
    Author     : bobby
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.model.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h2>You Searched: "<%= request.getAttribute("keyword") %>"</h2>

    <h3>The following is search result</h3>
    <%
        List<Movie> movies = (List<Movie>) request.getAttribute("movies");
        if (movies != null && !movies.isEmpty()) {
            for (Movie movie : movies) {
    %>
                <p><strong>Movie Title:</strong> <%= movie.getTitle() %></p>
                <p><strong>Lead Actor:</strong> <%= movie.getActor() %></p>
                <p><strong>Lead Actress:</strong> <%= movie.getActress() %></p>
                <p><strong>Genre:</strong> <%= movie.getGenre() %></p>
                <p><strong>Year:</strong> <%= movie.getYear() %></p>
                <hr>
    <%
            }
        } else {
    %>
        <p>No movie found.</p>
    <%
        }
    %>

    <br>
    <a href="searchMovie.jsp">Back to search page</a>
    <br>
    <a href="index.jsp">Back to main page</a>
    </body>
</html>
