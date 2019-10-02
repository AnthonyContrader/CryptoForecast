<%@ page language="java"
    pageEncoding="ISO-8859-1" 
    import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<%
			UserDTO user = (UserDTO)session.getAttribute("user");
			if(user != null) {
				if(user.getUsertype().toUpperCase().equals("ADMIN")) {
					// MENU ADMIN
					%>
					<div class="navbar">
					  <a href="homeadmin.jsp">Home</a>
					  <a href="UserServlet?mode=userlist">Users</a>
					  <a href="CoinServlet?mode=coinlist">Coins</a> 
					  <a href="TrendServlet?mode=trendlist">Trends</a>
					  <a href="LogoutServlet" id="logout">Logout</a>
					</div>
					<%
				} 	else {
					// MENU USER
					%>
					<div class="navbar">
					  	<a href="homeuser.jsp">Home</a>
					  	<a href="CoinServlet2?mode=coinlist">Coins</a> 
					  	<a href="TrendServlet?mode=trendlist">Trends</a>
						<a href="LogoutServlet" id="logout">Logout</a>
					</div>
					<%
				}		
				
			}
		%>
	</body>
</html>