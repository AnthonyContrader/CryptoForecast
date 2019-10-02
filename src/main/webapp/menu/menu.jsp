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
					  <a class="active" href="homeadmin.jsp">Home</a>
					  <a href="UserServlet?mode=userlist">Users</a>
					  <a href="CoinServlet?mode=coinlist">Coins</a> 
					  <a href="ForecastServlet?mode=forecastlist">Forecast</a>
					  <a href="TrendServlet?mode=trendlist">Trends</a>
					  <a href="LogoutServlet" id="logout">Logout</a>
					</div>
					<%
				} 
			}
		%>
	</body>
</html>