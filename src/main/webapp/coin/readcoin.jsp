<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CoinDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Coin</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<br>

<div class="main">
<%CoinDTO u = (CoinDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Name</th>
		<th>Quotation</th>
		<th>Symbol</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getQuotation()%></td>
		<td> <%=u.getSymbol()%></td>
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
