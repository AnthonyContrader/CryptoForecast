<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CoinDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Forecast Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp"%>




<div class="main">
	<%
		List<CoinDTO> list = (List<CoinDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Name Coin</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CoinDTO c : list) {
		%>
		<tr>
			<td><a href=CoinServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			

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