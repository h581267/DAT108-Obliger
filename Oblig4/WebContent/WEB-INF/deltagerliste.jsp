<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
    href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>

    <h2>Deltagerliste</h2>
    <table class="pure-table">
        <tr bgcolor="#cccccc">
            <th>Kjønn</th>
            <th align="left">Navn</th>
            <th align="left">Mobil</th>
        </tr>
 
    <c:forEach var="deltager" items="${deltagerliste}" varStatus="loop">
   
          
            <td align="center">&#9792;</td>
            <td><c:out value="{deltager.fornavn}" /></td>
            <td><c:out value="{deltager.etternavn}" /> </td> 
            <td><c:out value="{deltager.mobilnummer}" /></td>
       
   
    </c:forEach>
  
 </table>
</body>
</html>