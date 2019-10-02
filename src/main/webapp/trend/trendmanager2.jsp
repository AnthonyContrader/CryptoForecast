<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.TrendDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Trend Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp"%>

<%-- <div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="UserServlet?mode=trendlist">Trends</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>--%>

<div class="main">
	<%
		List<TrendDTO> list = (List<TrendDTO>)request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Time</th>
			<th>Variation</th>
			<th>Namecoin</th>
		</tr>
		<%
			for (TrendDTO t : list) {
		%>
		<tr>
			<td><a href=TrendServlet?mode=read&id=<%=t.getId()%>>
					<%=t.getTime()%>
			</a></td>
			<td><%=t.getVariation()%></td>
			<td><%=t.getNamecoin()%></td>
			

		</tr>
		<%
			}
		%>
	</table>




</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>