<%-- 
    Document   : InsertJstlSubmit
    Created on : Feb 20, 2016, 8:50:12 PM
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
        <title>Customer Insertion JSTL</title>
    </head>
    <body>
   <c:if test="${pageContext.request.method=='POST'}">      
                 <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull"
                           user="itmd4515" password="itmd4515"/>
  
                  
            
              
       
              <c:catch var ="catchException">
              <sql:update dataSource="${snapshot}" var="InsertCustomer">
           
             INSERT INTO customer (store_id,address_id, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)
              <sql:param value="2" />
            <sql:param value="8" />
            <sql:param value="${param.firstName}" />
            <sql:param value="${param.lastName}" />
            <sql:param value="${param.email}" />
          </sql:update>
              </c:catch>
             </c:if>
            
  
     <c:if test = "${catchException != null}">
   <p>The exception is : ${catchException} <br />
   There is an exception: ${catchException.message}</p>
   <p> Please correct the above mentioned error's and re-submit the form</p>
</c:if>
   
   <c:if test = "${InsertCustomer==1}" var="exception"> 
       <div class="alert alert-success">
        <p>The Customer ${param.firstName} is inserted </p>
         <form action="InsertJstl.jsp">
                    <input type="submit" name="insertAgain" id="insertAgain" value="InsertAgain"/>
             </form>
       </div>
    </c:if>
     <c:if test = "${InsertCustomer==0}" var="exception">      
         <div class="alert alert-warning">
        <p>The Customer Id ${param.firstName} cannot be inserted as there were issues </p>
         <form action="InsertJstl.jsp">
                    <input type="submit" name="insertAgain" id="insertAgain" value="InsertAgain"/>
             </form>
         </div>
    </c:if>
    
    
    
    </body>
</html>
