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
			<td><a href=SocialServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=SocialServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="SocialServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="social">Social Media</label>
    </div>
    <div class="col-75">
      <input type="text" id="url" name="url" placeholder="inserisci social">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Post</label>
    </div>
    <div class="col-75">
      <input type="text" id="quot" name="post" placeholder="inserisci il tuo post"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">data</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="symb" name="data" placeholder="inserisci la data del post"> 
    </div>
    </div>
  <div class="row">
    <div class="col-25">
      <label for="type">namecoin</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="name" name="namecoin" placeholder="inserisci il nome della moneta"> 
    </div>
    
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>