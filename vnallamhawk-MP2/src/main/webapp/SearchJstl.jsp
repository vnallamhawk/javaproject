<%-- 
    Document   : SearchJstl
    Created on : Feb 20, 2016, 6:51:25 PM
    Author     : VenkataRakesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Jstl Page</title>
    </head>
    <body>
       <form action="SearchJstlSubmit.jsp" method="post">
            <table>
                <tr>
                    <td>
                        <label for="Customer Id"> Enter the Customer ID to be searched  </label>
                    </td>
                    <td>
                        <input type="number" name="customerId" required>
                    </td>
                    </tr>
                    <tr>
                        <td>
                        <input type="submit" value="SEARCH"/>
                        </td>
            </tr>   
        </form>
    </body>
</html>
