<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CoinDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Coin Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp"%>

<%-- <div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="CoinServlet?mode=coinlist">Coins</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>--%>


<div class="main">
	<%
		List<CoinDTO> list = (List<CoinDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Quotation</th>
			<th>Symbol</th>
			
		</tr>
		<%
			for (CoinDTO c : list) {
		%>
		<tr>
			<td><a href=CoinServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getQuotation()%></td>
			<td><%=c.getSymbol()%></td>
			
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