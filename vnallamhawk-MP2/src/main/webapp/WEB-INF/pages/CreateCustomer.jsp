<%-- 
    Document   : customer
    Created on : Jan 24, 2016, 12:50:22 PM
    Author     : sas691
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

    <h1 align="center">Customer Insert</h1>
      
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
      
    <table class="table" align="center" style="width:40%;">
            <form method="POST" action="<c:url value="/insert"/>">
            
                <tr>
                    <td>
                <label for="customerId">Customer First Name</label>
                    </td>
                    <td>
                <input type="text" name="firstName" id="firstName"/>
                    </td>
                </tr>
            
            <tr>
                    <td>
                <label for="customerlastname">Customer Last Name</label>
                    </td>
                    <td>
                <input type="text" name="lastName" id="lastName"/>
                    </td>
                    </tr>
                    <tr>
                        
                        <td>
                <label for="email">Customer Email</label>
                        </td>
                        <td>
                <input type="email" name="email" id="email"/>
                        <td>
            </tr>
            <tr>
                <td>
                <label for="phone">Customer Phone</label>
                </td>
                <td>
                <input type="text" name="phone" id="phone"/>
                </td>
            </tr>
            <tr>
                <td>
                <label for="address">Customer Address</label>
                </td>
                <td>
                <input type="text" name="address" id="address"/>
                </td>
            </tr>
            <tr>
                <td>
                <label for="postalcode">Postal Code</label>
                </td>
                <td>
                <input type="text" name="postal_code" id="postal_code"/>
                </td>
            </tr>
            <tr>
                <td style="position:absolute;left:600px;">
            <input type="submit" name="submitCustomer" id="submitCustomer"/>
                </td>
            <tr>
        </form>
    </table>

    <%@include file="/WEB-INF/jspf/footer.jspf" %>