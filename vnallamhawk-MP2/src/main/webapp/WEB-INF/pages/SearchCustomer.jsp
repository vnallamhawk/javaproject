<%-- 
    Document   : delete
    Created on : Feb 18, 2016, 6:24:03 PM
    Author     : VenkataRakesh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customer</title>
    </head>
    <body>
        <c:if test="${not empty requestScope.violations}">
            <div class="alert alert-warning">
            <h2>Violations were found</h2>
            <ul>
                <c:forEach items="${requestScope.violations}" var="violation">     
                <li>
                    <c:out value="${violation.propertyPath}"/>:${violation.message}  
                </li>
                </c:forEach>
                
            </ul>
            </div>
        </c:if>
       <c:if test="${not empty requestScope.messages}">
    
        <c:forEach items="${requestScope.messages}" var="message">
            <div class="alert alert-success fade in">
            
                <strong><c:out value="${message.key}"/>: ${message.value} </strong>
            
            </div>
        </c:forEach>
    
        </c:if>

        <form action="search" method="post">
            <table class="table" align="center" style="width:40%;">
                <tr>
                    
                    <td>  
            <label for="Customer Id"> Enter the Customer ID to be searched </label>
                    </td>
                    <td>
            <input type="text" name="customerId"/>
                    </td>
            </tr>
            <tr>
                <td>
               
            
            <input type="submit" value="SEARCH CUSTOMER"/>
                </td>
            </tr>
            </table>
        </form>
            
    <table class="table" align="center" style="width:40%;">
            <tbody>
                
        <c:forEach items="${requestScope.customers}" var="customer">
            <tr>
            <th>ID</th>                
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>EMAIL</th>
            <th>PHONE</th>
            <th>ADDRESS</th>
            <th>POSTAL CODE</th>
                </tr>
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td>${customer.address}</td>
                <td>${customer.postal_code}</td>
                <td>
               <a href="<c:url value="/update"><c:param name="customerId" value="${customer.id}"/></c:url>">Update</a>
                </td>


            </tr>
        </c:forEach>        
    </tbody>    
    </table>
    </body>
</html>
