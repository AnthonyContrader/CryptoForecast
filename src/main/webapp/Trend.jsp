<%@ page import="it.contrader.dto.TrendDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Trend Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 
		<a href="/trend/getall">Coins</a> 
		<a class="active" href="/trend/getall">Trends</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<TrendDTO> list = (List<TrendDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Variations</th>
				<th>Date</th>
				<th>Idtrend</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (TrendDTO t : list) {
			%>
			<tr>
				<td><a href="/trend/read?id=<%=t.getId()%>"> <%=t.getVariation()%>
				</a></td>
				<td><%=t.getDate()%></td>
				<td><%=t.getIdcoin()%></td>
				<td><a href="/trend/preupdate?id=<%=t.getId()%>">Edit</a></td>


				<td><a href="/trend/delete?id=<%=t.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/trend/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Variation</label>
				</div>
				<div class="col-75">
					<input type="text" id="trend" name="variation"
						placeholder="inserisci variation">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Date</label>
				</div>
				<div class="col-75">
					<input type="text" id="date" name="date"
						placeholder="inserisci date">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label> Idcoin</label>
				</div>
				<div class="col-75">
					<input type="text" id="idcoi" name="idcoin"
						placeholder="inserisci idcoin">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>