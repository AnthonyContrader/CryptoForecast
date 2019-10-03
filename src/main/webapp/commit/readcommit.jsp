<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CommitDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Commit</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<br>

<div class="main">
<%CommitDTO u = (CommitDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Namecoin</th>
		<th>Number</th>
		<th>Data</th>
	</tr>
	<tr>
		<td><%=u.getNamecoin()%></td>
		<td> <%=u.getNumber()%></td>
		<td> <%=u.getData()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
