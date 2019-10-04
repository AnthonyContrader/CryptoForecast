<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.SocialDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Social Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp"%>




<div class="main">
	<%
		List<SocialDTO> list = (List<SocialDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Url</th>
			<th>Post</th>
			<th>Data</th>
			<th>Namecoin</th>
			<th></th>
		</tr>
		<%
			for (SocialDTO c : list) {
		%>
		<tr>
			<td><a href=SocialServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getUrl()%>
			</a></td>
			<td><%=c.getPost()%></td>
			<td><%=c.getData()%></td>
			<td><%=c.getNamecoin()%></td>
			
			

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