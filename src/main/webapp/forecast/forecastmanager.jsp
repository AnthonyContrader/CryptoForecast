<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CoinDTO"
	import="it.contrader.dto.TrendDTO"%>
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
		List<TrendDTO> list2 = (List<TrendDTO>) request.getAttribute("list2");
		
	%>

<br>

	<table>
		<tr>
			<th>Name Coin</th>
			<th>Quotation</th>
			<th>Variation</th>
			
		</tr>
		<%
			for (CoinDTO c : list) {
		%>
					
		<tr>
			<td><a href=CoinServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
					<%=c.getQuotation()%>
					<%= %>
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