<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SocialDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Coin</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<br>

<div class="main">
<%SocialDTO u = (SocialDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Url</th>
		<th>Post</th>
		<th>Data</th>
		<th>Namecoin</th>
		
	</tr>
	<tr>
		<td><%=u.getUrl()%></td>
		<td> <%=u.getPost()%></td>
		<td> <%=u.getData()%></td>
		<td> <%=u.getNamecoin()%></td>
		
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
