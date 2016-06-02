<%-- 
    Document   : DeleteJstlSubmit
    Created on : Feb 21, 2016, 1:43:34 PM
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
                <sql:update dataSource="${snapshot}" var="DeletePay">
                    Delete from payment where customer_id=?
                    <sql:param value="${param.customerId}" />
                </sql:update>
                <sql:update dataSource="${snapshot}" var="DeleteRen">
                    Delete from rental where customer_id=?
                    <sql:param value="${param.customerId}" />
                </sql:update>
                <sql:update dataSource="${snapshot}" var="DeleteCus">
                    Delete from customer where customer_id=?
                    <sql:param value="${param.customerId}" />
                </sql:update>
            </c:catch>
        </c:if>

        <c:if test = "${catchException != null}">
            <p>The exception is : ${catchException} <br />
                There is an exception: ${catchException.message}</p>
            Please correct the errors and submit the form again
        </c:if>

        <c:if test = "${DeleteCus==1}" var="exception"> 
            <div class="alert alert-success">
                <p>The Customer Id ${param.customerId} is deleted </p>
                <form action="DeleteJstl.jsp">
                    <input type="submit" name="submit" id="searchAgain" value="DeleteAgain"/></span>
            </div>
        </c:if>
        <c:if test = "${DeleteCus==0}" var="exception">  
            <div class="alert alert-warning">
                <p>The Customer Id ${param.customerId} does not exist </p>
                <form action="DeleteJstl.jsp">
                    <input type="submit" name="submit" id="searchAgain" value="SearchAgain"/></span>
            </div>
        </c:if>
    </body>
</html>
