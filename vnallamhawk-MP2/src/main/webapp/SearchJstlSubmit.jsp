<%-- 
    Document   : SearchJstlSubmit
    Created on : Feb 21, 2016, 2:46:51 PM
    Author     : VenkataRakesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Customer</title>
</head>
<c:set var="recordExist" value="0"/>
<c:if test="${pageContext.request.method=='POST'}">      
    <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull"
                       user="itmd4515" password="itmd4515"/>
    <c:catch var ="catchException">
        <sql:query dataSource="${snapshot}" var="Search">
            select * from customer c,address a where c.address_id=a.address_id and c.customer_id=?;
            <sql:param value="${param.customerId}" />
        </sql:query>
    </c:catch>
</c:if>

<c:if test = "${catchException != null}">
    <p>The exception is : ${catchException} <br />
        There is an exception: ${catchException.message}</p>
    </c:if>



<c:forEach items="${Search.rows}" var="records">
    <c:set var="recordExist" value="1"/>







    <form method="POST" action="UpdateJstl.jsp">

        <table class="table" style="width:33%;alight:center">
            <tr>
                <td>
                    <label for="customerId">Customer ID</label>
                </td>
                <td>
                    <input type="text" name="customerId" readonly="readonly" id="firstName" value="${records.customer_id}"/>
                </td>
            </tr>
            </div>

            <tr>
                <td>
                    <label for="customerId">Customer First Name</label>
                </td>
                <td>
                    <input type="text" name="firstName" id="firstName" value="${records.first_name}" required/>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="customerId">Customer Last Name</label>
                </td>
                <td>
                    <input type="text" name="lastName" id="lastName" value="${records.last_name}" required/>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="email">Customer Email</label>
                </td>
                <td>
                    <input type="email" name="email" id="email" value="${records.email}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="storeid">Phone</label>
                </td>

                <td>
                    <input type="text" name="phone" id="phone" value="${records.phone}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="addressid">Address</label>
                </td>
                <td>
                    <input type="text" name="address" id="address" value="${records.address}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="addressid">Postal Code</label>
                </td>
                <td>
                    <input type="text" name="postal_code" id="postal_code" value="${records.postal_code}"/>
                    <input type="hidden" name="address_id" id="address_Id" value="${records.address_id}"/>
                </td>
            </tr>
            <tr>
                <td style="position:absolute;left:178px;">

                    <input type="submit" name="submitCustomer" id="submitCustomer"/>
                </td>

            </tr>

        </table>
    </form>

</c:forEach>

<c:if test = "${recordExist==0}" var="exception"> 
    <div class="alert alert-warning">
        <span>  The Customer Id ${param.customerId} does not exist. Please resubmit your form

            <form action="SearchJstl.jsp">
                <input type="submit" name="submit" id="searchAgain" value="SearchAgain"/>
            </form>

        </span>

    </div>
</c:if>

</html>






