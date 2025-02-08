<%-- 
    Document   : success
    Created on : 2025年2月7日, 下午10:12:05
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
        <%
            int bookCount = (int)request.getAttribute("bookCount");
           
        %>
        <h1><%=bookCount %>Book adds successfully!</h1>
         <a href="index.jsp">Back to main page.</a>
    </body>
</html>
