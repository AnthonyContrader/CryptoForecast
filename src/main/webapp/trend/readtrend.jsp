<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrendDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="TrendServlet?mode=usetrendlist">Trends</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%TrendDTO t = (TrendDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Time</th>
		<th>Variation</th>
		<th>Namecoin</th>
	</tr>
	<tr>
		<td><%=t.getTime()%></td>
		<td> <%=t.getVariation()%></td>
		<td> <%=t.getNamecoin()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>