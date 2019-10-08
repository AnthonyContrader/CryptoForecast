<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.SocialDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Social</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href="/user/getall">Users</a>
		<a href="/coin/getall">Coins</a>
		<a href="/trend/getall">Trends</a>
		<a class="active" href="/social/getall">Socials</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			SocialDTO u = (SocialDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>Id</th>
				<th>Reddit</th>
				<th>Telegram</th>
				<th>Likefb</th>
				<th>Twitter</th>
				
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getReddit()%></td>
				<td><%=u.getTelegram()%></td>
				<td><%=u.getLikefb()%></td>
				<td><%=u.getTwitter()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>