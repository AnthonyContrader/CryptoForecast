<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.CoinDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Coin</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href="/coin/getall">Coins</a>
		<a href="/trend/getall">Trends</a>  
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			CoinDTO u = (CoinDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Namecoin</th>
				<th>Price</th>
				<th>Circulating</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getNamecoin()%></td>
				<td><%=u.getPrice()%></td>
				<td><%=u.getCirculating()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>