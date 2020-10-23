<%@ include file="sidebar.jsp"%>
<%@ include file="header.jsp"%>

<div class="container-fluid  center">
	

	<div class="center">
	

 <table id="canjobListTable" border="1" align="center">
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
</div>
</div>
</body>
</html>