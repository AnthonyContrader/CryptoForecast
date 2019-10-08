<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrendDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/trend/getall">Users</a>
  <a href="/coin/getall">Coins</a>
  
  <a class="active" href="/trend/getall">Trends</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%TrendDTO u = (TrendDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/trend/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="trend">Variation</label>
    </div>
    <div class="col-75">
      <input type="text" id="coin" name="variation" value=<%=u.getVariation()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Date</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="date" value=<%=u.getDate()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Idcoin</label>
    </div>
   		 <div class="col-75">
 			<input
			type="text" id="circ" name="idcoin" value=<%=u.getIdcoin()%>> 
    	</div>
    	<input type="hidden" name="id" value =<%=u.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>