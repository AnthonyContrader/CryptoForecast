<%@ page import="it.contrader.dto.CoinDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a class="active" href="/user/getall">Coins</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CoinDTO> list = (List<CoinDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Namecoin</th>
				<th>Price</th>
				<th>Circulanting</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (CoinDTO c : list) {
			%>
			<tr>
				<td><a href="/coin/read?id=<%=c.getId()%>"> <%=c.getNamecoin()%>
				</a></td>
				<td><%=c.getPrice()%></td>
				<td><%=c.getCirculating()%></td>
				<td><a href="/coin/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/coin/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/coin/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Namecoin</label>
				</div>
				<div class="col-75">
					<input type="text" id="coin" name="namecoin"
						placeholder="inserisci namecoin">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Price</label>
				</div>
				<div class="col-75">
					<input type="text" id="pric" name="price"
						placeholder="inserisci price">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label> Circulating</label>
				</div>
				<div class="col-75">
					<input type="text" id="circ" name="cilculating"
						placeholder="inserisci circulating">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>