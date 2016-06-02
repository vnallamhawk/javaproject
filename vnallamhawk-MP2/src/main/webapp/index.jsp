<%-- 
    Document   : customer
    Created on : Jan 24, 2016, 12:50:22 PM
    Author     : sas691
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jspf/header.jspf" %>
<head>
    <style>
        table {
  border-collapse: separate;
  border-spacing: 50px 0;
}

td {
  padding: 10px 0;
}
        </style>
    
<!--  reference:      http://stackoverflow.com/questions/17469483/how-to-increase-the-distance-between-table-columns-in-html-->
</head>
 <table align="center" >
   <form action="insert">
       <tr>
           <td>
               <label for="inputEmail">Insert Customer</label></td>
           <td><input type="submit" value="Insert Customer"></td>
       </tr>
   </form>
   <form action="customerlist">
       <tr>
           <td>
     <label for="inputEmail">List All Customers </label>
           </td>
           <td>
    <input type="submit"value="List All Customers">
           </td>
       </tr>
   </form>
    <form action="search">
        <tr>
        <td>
     <label for="inputEmail">Search Customers </label>
     </td>
     <td>
    <input type="submit"value="Search Customer">
     </td>
        </tr>
   </form>
   <form action="delete">
       <tr>
           
           <td>
        
     <label for="inputEmail">Delete Customer </label>
           </td>
           <td>
    <input type="submit"value="Delete Customer">
           </td>
        </tr>
 
   </form>


   <form action="InsertJstl.jsp">
       <tr>   
           <td>
    <label for="inputEmail">Insert Customer(JSTL)</label>
           </td>
           <td>
    <input type="submit"value="Insert Customer">
           </td>
    </tr>   
   </form>
     <tr>
         <td>
     <label for="inputEmail">Search Customer(JSTL)</label>
         </td>
    <form action="SearchJstl.jsp">
        <td>
    <input type="submit"value="Search Customers">
        </td>
    </tr>
   </form>
     
     <tr>
         <td>
     <label for="inputEmail">Display Customer(JSTL)</label>
         </td>
     <form action="DisplayJstl.jsp">
         <td>
    <input type="submit"value="Display Customers">
         </td>
   </form>
     
     <tr>
         
         <td>
     <label for="inputEmail">Delete Customer(JSTL)</label>
         </td>
         
     <form action="DeleteJstl.jsp">
         <td>
    <input type="submit"value="Delete Customers">
         </td>
    </tr>
   </form>
     </table>
    <%@include file="/WEB-INF/jspf/footer.jspf" %>