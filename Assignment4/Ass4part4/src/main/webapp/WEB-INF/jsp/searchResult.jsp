<%-- 
    Document   : searchResult
    Created on : 2025年2月18日, 下午9:47:22
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results</title>
    </head>
    <body>
        <h1>Search Results</h1>
        <c:choose>
            <c:when test="${not empty movies}">
                <table border='1'>
                    <tr>
                        <th>Title</th>
                        <th>Actor</th>
                        <th>Actress</th>
                        <th>Genre</th>
                        <th>Year</th>
                    </tr>
                    <c:forEach var="movie" items="${movies}">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.actor}</td>
                            <td>${movie.actress}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.year}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
            <p>No movies found matching your search criteria.</p>
            </c:otherwise>
        </c:choose>
    <br>
    <a href="home.htm">Back to Home</a>
    </body>
</html>
