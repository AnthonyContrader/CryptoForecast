<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SocialDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Social</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/coin/getall">Users</a>
  <a href="/user/getall">Coins</a>
  <a  href="/trend/getall">Trends</a>
    <a class="active" href="/social/getall">Socials</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%SocialDTO u = (SocialDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/social/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Reddit</label>
				</div>
				<div class="col-75">
					<input type="text" id="user" name="reddit"
						value=<%=u.getReddit()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="pass">telegram</label>
				</div>
				<div class="col-75">
					<input type="text" id="tele" name="telegram"
						value=<%=u.getTelegram()%>>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Likefb</label>
				</div>
				<div class="col-75">
					<input type="text" id="lik" name="likefb"
						value=<%=u.getLikefb()%>>
					
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Twitter</label>
				</div>
				<div class="col-75">
					<input type="text" id="tw" name="twitter"
						value=<%=u.getTwitter()%>>
					
				</div>
				<input type="hidden" name="id" value =<%=u.getId() %>>
			</div>
			<button type="submit">edit</button>
		</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>