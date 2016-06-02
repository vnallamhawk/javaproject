<%-- 
    Document   : DisplayJstl
    Created on : Feb 20, 2016, 9:57:07 PM
    Author     : VenkataRakesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@include file="/WEB-INF/jspf/header.jspf" %>

<html>
    <head>
        <title>Customer List</title>
    </head>
    <body>

        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull"
                           user="itmd4515"  password="itmd4515"/>

        <sql:query dataSource="${snapshot}" var="result">
            select * from customer LEFT JOIN address on customer.address_id=address.address_id order by customer.last_update desc;
        </sql:query>

        <table class="table" align="center" border="1" style=" width:80%">
            <tr>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Postal Code</th>
            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.customer_id}"/></td>
                    <td><c:out value="${row.first_name}"/></td>
                    <td><c:out value="${row.last_name}"/></td>
                    <td><c:out value="${row.email}"/></td>
                    <td><c:out value="${row.address}"/></td>
                    <td><c:out value="${row.phone}"/></td>
                    <td><c:out value="${row.postal_code}"/></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>