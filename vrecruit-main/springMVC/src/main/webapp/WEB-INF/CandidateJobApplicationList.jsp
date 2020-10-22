<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
    <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Job Applications</title>
</head>
<body>
<a href="/app">Home</a>
<a href="/app/dashboard">Dasboard</a>
<h1>All JobApplication List</h1>
<br/><br/>

 <table border="1">
 <c:forEach items="${lst}" var="i">
 <br/>
 
 	    <tr>
        <th><b>title: <c:out value="${i.title}"/> </b></th>
        <td>category: <c:out value="${i.category}"/></td>  
        <td>position_type: <c:out value="${i.position_type}"/></td> 
        <td>job_description: <c:out value="${i.job_description}"/></td> 
        <td>rounds: <c:out value="${i.rounds}"/></td>
        <td>
        	<!-- It will give job id as requestparameter-->
	    	<form action="apply" method="get" style="display:inline;">
	    		<input type="hidden" name="id" value="${i.jid}" >
	    		<input type="submit" value="apply">
	    	</form>
    	</td>
    	<td>
       
    	</td>
    	</tr>
 </c:forEach>
</table>
</body>
</html>