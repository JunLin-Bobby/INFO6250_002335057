<%-- 
    Document   : demo
    Created on : 2025年2月5日, 下午1:26:14
    Author     : bobby
--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ass3part3</title>
    </head>
    <body>
        <h1>JSTL CTag Library Demo</h1>
        <!--Using  c:out-->
        <h2>Using  c:out</h2>
        <c:set var="message" value="Using JSTL Cout tag:"/>
        <p>Message: <c:out value="${message}"/></p> 
        <!--Using  c:forEach-->
        <h2>Using  c:foreach</h2>
        <ul>
            <c:forEach var="item" items="${['Apple','Orange','Watermelon']}">
                <li><c:out value="${item}"/></li>
           </c:forEach>
        </ul>
        <!--Using c:if-->
        <h2>Using  c:if</h2>
        <c:set var="showText" value= "true"/>
        <c:if test ="${showText}">
            <p>This sentence is shown because "showText's" value is true.</p>
        </c:if>   
            
        <h1>JSTL Formatting Tag Library Demo</h1> 
        <h2>Using fmt:formatNumber</h2>
        <c:set var="price" value ="7777.789"/>
        <p>Original value:${price}</p>
        <p>Formatting as Currency: <fmt:formatNumber value="${price}" type ="currency" currencySymbol="$"/></P>
        
        <h2>Using fmt:formatDate</h2>
        <c:set var="now" value="<%= new java.util.Date()%>"/>
        <p>Current Time: <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="short"/></p>
        
        <h2>Using fmt:timeZone</h2>
        <fmt:timeZone value="Asia/Tokyo">
        <p>Tokyo Time: <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="short"/></p>
        </fmt:timeZone>
        
        
        <h1>JSTL Fn Tag Library Demo</h1>
        <h2>Using fn:length calculate the length of string</h2>
         <c:set var="text" value="Hello JSTL!" />
        <p>String "<c:out value="${text}"/>"'s length:<c:out value="${fn:length(text)}"/></p>
        
        <h2>Using fn:contain to check String.</h2>
        <c:set var="test" value="aabbccc"/>
        <c:if test="${fn:contains(test,'ab')}">
            <p>
                Stirng "<c:out value="${test}"/> includes "ab"
            </p>
        </c:if>
        <h2>Using fn:toUppercase at "aabbcc"</h2>
        <p>Convert to upper case：<c:out value="${fn:toUpperCase(test)}"/></p>
        
        
        
       <h1>JSTL XML Tag Library Demo</h1> 
       <!--       Using x:parse -->
       <x:parse var="books">
           <books>
               <book>
                   <title>Book for demo</title>
                   <author>Jun Lin</author>
               </book>
               <book>
                   <title>Book for demo2</title>
                   <author>Jun Lin</author>
               </book>
               <book>
                   <title>Book for demo3</title>
                   <author>Jun Lin</author>
               </book>
           </books>
       </x:parse>
<!--       Using x:out-->
       <h3>The first book(x:out)</h3>
       <p>Title :<x:out select = "$books/books/book[1]/title"/></p>
       <p>Author :<x:out select = "$books/books/book[1]/author"/></p>
<!--       Using x:if--> 
       <h3>Check whether there is "Book for demo2."</h3>
       <x:if select = "$books/books/book[title='Book for demo']">
           <p>Book found! 
              The author is 
              <x:out select = "$books/books/book[title='Book for demo']/author"/>
           </p>
       </x:if>
        
        
       <h1>JSTL SQL Tag Library Demo</h1> 
        <sql:setDataSource 
        var="db" 
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC"
        user="jun6250" 
        password="0000" />
        <!-- Counducting SQL Query-->
         <!-- Updating SQL DATA-->
        <sql:update dataSource="${db}">
        INSERT INTO usersAss3part3 (username, email) VALUES ('David', 'david@example.com');
        </sql:update>    
        <sql:query dataSource="${db}" var="result">
        SELECT id, username, email FROM usersAss3part3;
        </sql:query>
        <h3>Users data in the table of database</h3>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>UserName></th>
                <th>email</th>
            </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.id}"/></td>
                <td><c:out value="${row.username}"/></td>
                <td><c:out value="${row.email}"/></td>
            </tr>
        </c:forEach>
         </table>    
    </body>
</html>
