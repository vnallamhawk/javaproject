<%-- 
    Document   : UpdateJstl
    Created on : Feb 21, 2016, 2:56:42 PM
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
        <title>Delete Customer</title>
    </head>
    <body>
        <c:if test="${pageContext.request.method=='POST'}">      
            <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                               url="jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull"
                               user="itmd4515" password="itmd4515"/>
            <c:catch var ="catchException">
                <sql:update dataSource="${snapshot}" var="UpdateCust">
                    Update Customer set first_name=?,last_name=?,email=? where customer_id=?;
                    <sql:param value="${param.firstName}" />
                    <sql:param value="${param.lastName}" />
                    <sql:param value="${param.email}" />
                    <sql:param value="${param.customerId}" />
                </sql:update>
                <sql:update dataSource="${snapshot}" var="UpdateAddr">
                    Update Address set phone=?,address=?,postal_code=? where address_id=?;
                    <sql:param value="${param.phone}" />
                    <sql:param value="${param.address}" />
                    <sql:param value="${param.postal_code}" />
                    <sql:param value="${param.address_id}" />
                </sql:update>
            </c:catch>
        </c:if>

        <c:if test = "${catchException != null}">
            <p>The exception ${param.addressId} is : ${catchException} <br />
                There is an exception: ${catchException.message}</p>
            <p> Please correct the error's and re-submit the form</p>
        </c:if>

        <c:if test = "${catchException != null}">

            <p>The exception is : ${catchException} <br />
                There is an exception: ${catchException.message}</p>
            </c:if>

        <c:if test="${UpdateAddr == 1 && UpdateCust == 1}" var="exception">    
            <p> The customer details for ${param.firstName} has been updated </p>
        </c:if>


    </body>
</html>

