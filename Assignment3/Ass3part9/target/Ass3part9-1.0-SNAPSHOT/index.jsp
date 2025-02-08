<%-- 
    Document   : index
    Created on : 2025年2月6日, 下午8:44:35
    Author     : bobby
--%>
<%@ taglib prefix="mytags" uri="/WEB-INF/csvtag.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>CSV Data Viewer</title>
</head>
<body>
    <h1>CSV Data Viewer</h1>
    <form method="get">
        <label for="csvFileName">Enter CSV File Name:</label>
        <input type="text" name="csvFileName" placeholder="parking_facilities.csv" required>
        <button type="submit">View Data</button>
    </form>

    <hr>

 <%-- Loading CSV file's Name --%>
    <%
        String csvFile = request.getParameter("csvFileName");
        if (csvFile != null && !csvFile.trim().isEmpty()) {
            ServletContext context = request.getServletContext();
            String filePath = context.getRealPath("/WEB-INF/data/" + csvFile);
    %>
            <h2>CSV File Path:</h2>
            <p style="color: blue;"><%= filePath %></p> 

            <h2>Data from <%= csvFile %></h2>
            <mytags:csvData fileName="<%= csvFile %>"/>
    <% } %>

</body>
</html>
