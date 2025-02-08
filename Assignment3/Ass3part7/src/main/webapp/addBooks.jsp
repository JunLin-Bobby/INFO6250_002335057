<%-- 
    Document   : addBooks
    Created on : 2025年2月7日, 下午8:31:18
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
        <h2>Please enter information of books which you want to add.</h2>
        <form action="BookServlet" method="POST">
        <table border='1'>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
            </tr>
       
        <%
            int bookCount = (int)request.getSession().getAttribute("bookCount");
            for(int i=0 ;i<bookCount;i++){
        %>
            <tr>
                <td><input type='text' name='isbn' required></td>
                <td><input type='text' name='title' required></td>
                <td><input type='text' name='author' required></td>
                <td><input type='number' step='0.01' name='price' required></td>
            </tr>
            
        <%}%>
        
        </table>
        <button type="submit">submit</button>
        </form>
    </body>
</html>
