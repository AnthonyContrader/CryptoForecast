<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CommitDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Commit Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Commit</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a href="/coin/getall">Coins</a>
		<a href="/trend/getall">Trends</a>
		<a class="active" href="/commit/getall">Commit</a>
		<a href="/social/getall">Socials</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			CommitDTO u = (CommitDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Id</th>
				<th>Stars</th>
				<th>Fork</th>
				<th>Watcher</th>
				<th>Collaborators</th>
				<th>Number</th>
				
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getStars()%></td>
				<td><%=u.getFork()%></td>
				<td><%=u.getWatcher()%></td>
				<td><%=u.getCollaborators()%></td>
				<td><%=u.getNumber()%></td>
				
				
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>