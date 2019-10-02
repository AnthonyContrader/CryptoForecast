<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CoinDTO"
    import="it.contrader.dto.TrendDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Forecast</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<br>

<div class="main">
<%CoinDTO c = (CoinDTO) request.getAttribute("dto");%>
<%TrendDTO t = (TrendDTO) request.getAttribute("dto");%>

<table>
	<tr> 
		<th>Name coin</th>
		<th>Forecast 1M</th>
		<th>Forecast 2M</th>
		<th>Forecast 3M</th>
	</tr>
	<tr>
		<td><%=c.getName()%></td>
		<td><%=t.getVariation()%> </td>
		<td><%=t.getVariation()%> </td>
		<td><%=t.getVariation()%> </td>
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
