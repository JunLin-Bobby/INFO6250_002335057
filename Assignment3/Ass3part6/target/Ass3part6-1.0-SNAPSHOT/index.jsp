<%-- 
    Document   : index.jsp
    Created on : 2025年2月6日, 下午12:03:37
    Author     : bobby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fronpage</title>
    </head>
    <body>
        <h1>Welcome to Movie Store.</h1>
        <form action = index.jsp method="post">
            <label for="select action" >Please slecet...</label>
            <select name ="action">
                <option value="">Please slecet...</option>
                <option value="addMovie.jsp">Add movies</option>
                <option value="searchMovie.jsp">Browse movies</option>
            </select>
            <button type='submit'>Send</button>
        </form>
        <% 
            String action =request.getParameter("action");
            if(action!=null&&!action.isEmpty()){
                response.sendRedirect(action);
            }
        %>
    
    </body>
</html>
