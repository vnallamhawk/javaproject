<%-- 
    Document   : delete
    Created on : Feb 18, 2016, 6:24:03 PM
    Author     : VenkataRakesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <h1 align="center">Customer Delete</h1>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Customer</title>
    </head>
    <body>
         <c:if test="${not empty requestScope.messages}">
    
        <c:forEach items="${requestScope.messages}" var="message">
            <div class="alert alert-success fade in">
            
                <strong><c:out value="${message.key}"/>: ${message.value} </strong>
            
            </div>
        </c:forEach>
    
        </c:if>

        <form action="delete" method="post">
            <table class="table" align="center" style="width:40%;">
                <tr>
                    <td>
                        <label for="Customer Id"> Enter the Customer ID to be deleted from the list below </label>
                    </td>
                    <td>
            <input type="text" name="customerId"/>
                    </td>
                    </tr>
                    <tr>
                        <td style="position:absolute;left:600px;">
            <input type="submit" value="DELETE CUSTOMER"/>
                        </td>
            </tr>   
        </form>
        
    </body>
</html>
