<%-- 
    Document   : UpdateCustomer
    Created on : Feb 19, 2016, 6:51:02 PM
    Author     : VenkataRakesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
    </head>
    <body> 
        <c:if test="${not empty requestScope.messages}">
    
        <c:forEach items="${requestScope.messages}" var="message">
            <div class="alert alert-success fade in">
            
                <strong><c:out value="${message.key}"/>: ${message.value} </strong>
            
            </div>
        </c:forEach>
    
        </c:if>
         <form method="POST" action="<c:url value="/update"/>">

             <table class="table" style="width:33%;alight:center">
                 <tr>
                     <td>
                <label for="customerId">Customer ID</label>
                     </td>
                     <td>
                <input type="text" name="customerId" readonly="readonly" id="firstName" value="${customerupdate[0].id}"/>
                     </td>
            </tr>
            </div>
            
                <tr>
                    <td>
                <label for="customerId">Customer First Name</label>
                    </td>
                    <td>
                <input type="text" name="firstName" id="firstName" value="${customerupdate[0].firstName}"/>
                    </td>
                </tr>
            
                <tr>
                    <td>
                <label for="customerId">Customer Last Name</label>
                    </td>
                <td>
                <input type="text" name="lastName" id="lastName" value="${customerupdate[0].lastName}"/>
                </td>
                </tr>
           
                <tr>
                    <td>
                <label for="email">Customer Email</label>
                    </td>
                    <td>
                <input type="email" name="email" id="email" value="${customerupdate[0].email}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                <label for="storeid">Phone</label>
                    </td>
                    
                    <td>
                <input type="text" name="phone" id="phone" value="${customerupdate[0].phone}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                <label for="addressid">Address</label>
                    </td>
                    <td>
                <input type="text" name="address" id="address" value="${customerupdate[0].address}"/>
                </td>
                </tr>
                <tr>
                    <td>
                <label for="addressid">Postal Code</label>
                    </td>
                    <td>
                <input type="text" name="postal_code" id="postal_code" value="${customerupdate[0].postal_code}"/>
                    </td>
            </tr>
            <tr>
                <td style="position:absolute;left:178px;">

            <input type="submit" name="submitCustomer" id="submitCustomer"/>
                </td>
                
                </tr>
            
             </table>
        </form>
       
    </body>
</html>
