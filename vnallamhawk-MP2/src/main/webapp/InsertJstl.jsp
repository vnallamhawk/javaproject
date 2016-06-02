<%-- 
    Document   : InsertCustomerJstl
    Created on : Feb 20, 2016, 6:23:18 PM
    Author     : VenkataRakesh
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : customer
    Created on : Jan 24, 2016, 12:50:22 PM
    Author     : sas691
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>

<h1>JSTL Insert</h1>

<c:if test="${not empty requestScope.violations}">
    <h2>Violations were found</h2>
    <ul>
        <c:forEach items="${requestScope.violations}" var="violation">     
            <li>
                <c:out value="${violation.propertyPath}"/>:${violation.message}  
            </li>
        </c:forEach>

    </ul>
</c:if>

<form method="POST" action="InsertJstlSubmit.jsp">
    <div>
        <label for="customerId">Customer First Name</label>
        <input type="text" name="firstName" id="firstName"/>
    </div>
    <div>
        <label for="customerId">Customer Last Name</label>
        <input type="text" name="lastName" id="lastName"/>
    </div>
    <div>
        <label for="email">Customer Email</label>
        <input type="email" name="email" id="email"/>
    </div>

    <input type="submit" name="submitCustomer" id="submitCustomer"/>
</form>


<c:if test="${pageContext.request.method=='POST'}">
    <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull"
                       user="itmd4515"  password="itmd4515"/>
    Insert into customer(store_id,first_name,last_name,email,address_id)values(1,?,?,?,605);
    <sql:update dataSource="{snapshot}" var="inserted">
        <sql:param value="${param.firstName}" />
        <sql:param value="${param.lastName}" />
        <sql:param value="${param.email}" />
    </sql:update>

</c:if>





<%@include file="/WEB-INF/jspf/footer.jspf" %>