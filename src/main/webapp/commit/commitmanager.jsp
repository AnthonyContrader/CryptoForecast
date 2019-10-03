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
			<td><a href=CommitServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getNamecoin()%>
			</a></td>
			<td><%=c.getNumber()%></td>
			<td><%=c.getData()%></td>
			<td><a href=CommitServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CommitServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="CommitServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="commit">Namecoin</label>
    </div>
    <div class="col-75">
      <input type="text" id="coin" name="name" placeholder="inserisci name moneta">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="numb">Number</label>
    </div>
    <div class="col-75">
      <input type="text" id="numb" name="numero" placeholder="inserisci numero"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Data</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="symb" name="data" placeholder="inserisci data"> 
  				
			
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>