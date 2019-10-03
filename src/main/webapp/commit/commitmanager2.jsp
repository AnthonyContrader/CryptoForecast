<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CommitDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Commit Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp"%>




<div class="main">
	<%
		List<CommitDTO> list = (List<CommitDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Namecoin</th>
			<th>Number</th>
			<th>Data</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (CommitDTO c : list) {
		%>
		<tr>
			<td><a href=CommitServlet2?mode=read&id=<%=c.getId()%>>
					<%=c.getNamecoin()%>
			</a></td>
			<td><%=c.getNumber()%></td>
			<td><%=c.getData()%></td>
			<td><a href=CommitServlet2?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CommitServlet2?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

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