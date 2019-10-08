<%@ page import="it.contrader.dto.CommitDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Commit Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a> 	
		<a href="/coin/getall">Coins</a>
		<a href="/trend/getall">Trends</a> 
		<a class="active" href="/commit/getall">Commits</a>
		<a href="/social/getall">Socials</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<CommitDTO> list = (List<CommitDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Stars</th>
				<th>Fork</th>
				<th>Watcher</th>
				<th>Collaborators</th>
				<th>Number</th>
			</tr>
			<%
				for (CommitDTO c : list) {
			%>
			<tr>
				<td><a href="/commit/read?id=<%=c.getId()%>"> <%=c.getStars()%>
				</a></td>
				<td><%=c.getFork()%></td>
				<td><%=c.getWatcher()%></td>
				<td><%=c.getCollaborators()%></td>
				<td><%=c.getNumber()%></td>
				<td></td>
				<td></td>
				<td><a href="/commit/preupdate?id=<%=c.getId()%>">Edit</a></td>


				<td><a href="/commit/delete?id=<%=c.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/commit/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Stars</label>
				</div>
				<div class="col-75">
					<input type="text" id="commit" name="stars"
						placeholder="inserisci numero di stelle">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">Fork</label>
				</div>
				<div class="col-75">
					<input type="text" id="pric" name="fork"
						placeholder="inserisci numero fork">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label> Watcher</label>
				</div>
				<div class="col-75">
					<input type="text" id="circ" name="watcher"
						placeholder="inserisci watcher">
				</div>
				</div>
				<div class="row">
				<div class="col-25">
					<label> Collaborators</label>
				</div>
				<div class="col-75">
					<input type="text" id="circ" name="collaborators"
						placeholder="inserisci collaborators">
				</div>
				</div>
				<div class="row">
				<div class="col-25">
					<label> Number</label>
				</div>
				<div class="col-75">
					<input type="text" id="circ" name="number"
						placeholder="inserisci number">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>