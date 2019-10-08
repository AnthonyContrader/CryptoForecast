<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CoinDTO"%>
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
  <a href="/coin/getall">Users</a>
  <a class="active" href="/user/getall">Coins</a>
  <a  href="/trend/getall">Trends</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CoinDTO u = (CoinDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/coin/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="coin">Namecoin</label>
    </div>
    <div class="col-75">
      <input type="text" id="coin" name="namecoin" value=<%=u.getNamecoin()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Price</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="price" value=<%=u.getPrice()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Circulating</label>
    </div>
   		 <div class="col-75">
 			<input
			type="text" id="circ" name="circulating" value=<%=u.getCirculating()%>> 
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