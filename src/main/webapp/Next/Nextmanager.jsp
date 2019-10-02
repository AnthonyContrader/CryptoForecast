<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.CoinDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Next Manager</title>
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
			<th>Six</th>
			<th>Sixty</th>
			<th>Thousand</th>
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
			<td><%=c.getQuotation()%></td>
			<td><%=c.getSymbol()%></td>
			<td><a href=CoinServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CoinServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="CoinServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="coin">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="coin" name="name" placeholder="inserisci name">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Quotation</label>
    </div>
    <div class="col-75">
      <input type="text" id="Six" name="Sixty" placeholder="inserisci Sixty"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Symbol</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="Thou" name="Thousand" placeholder="inserisci Thousand"> 
  				
			
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>