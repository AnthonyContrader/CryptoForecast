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
			<th></th>
			<th></th>
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
			<td><a href=TrendServlet?mode=read&update=true&id=<%=t.getId()%>>Edit</a>
			</td>
			<td><a href=TrendServlet?mode=delete&id=<%=t.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="TrendServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="trend">Time</label>
    </div>
    <div class="col-75">
      <input type="text" id="trend" name="time" placeholder="inserisci data">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Variation</label>
    </div>
    <div class="col-75">
      <input type="text" id="variat" name="variation" placeholder="inserisci variazione"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Namecoin</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="symb" name="namecoin" placeholder="inserisci nomemoneta"> 
  				
			
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>