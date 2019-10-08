<%@ page import="it.contrader.dto.SocialDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Social Manager</title>

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
	<div class="main">
		<%
			List<SocialDTO> list = (List<SocialDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Reddit</th>
				<th>Telegram</th>
				<th>Likefb</th>
				<th>Twitter</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (SocialDTO s : list) {
			%>
			<tr>
				<td><a href="/social/read?id=<%=s.getId()%>"> <%=s.getReddit()%>
				</a></td>
				<td><%=s.getTelegram()%></td>
				<td><%=s.getLikefb()%></td>
				<td><%=s.getTwitter()%></td>
				<td><a href="/social/preupdate?id=<%=s.getId()%>">Edit</a></td>


				<td><a href="/social/delete?id=<%=s.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/social/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Reddit</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="reddit"
						placeholder="inserisci numero iscritti a reddit">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">telegram</label>
				</div>
				<div class="col-75">
					<input type="text" id="tele" name="telegram"
						placeholder="inserisci numero utenti canale telegram">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Likefb</label>
				</div>
				<div class="col-75">
					<input type="text" id="lik" name="likefb"
						placeholder="inserisci numero like facebook">
					
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Twitter</label>
				</div>
				<div class="col-75">
					<input type="text" id="tw" name="twitter"
						placeholder="inserisci numero tweet">
					
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>