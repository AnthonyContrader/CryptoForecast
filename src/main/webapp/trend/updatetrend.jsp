<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TrendDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Trend</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>
<br>
<div class="main">

<%TrendDTO u = (TrendDTO) request.getAttribute("dto");%>


<form id="floatleft" action="UserServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">Time</label>
    </div>
    <div class="col-75">
      <input type="text" id="time" name="time" value=<%=u.getTime()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Variation</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="var" name="variation" value=<%=u.getVariation()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Namecoin</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="text" name="namecoin" value=<%=u.getNamecoin()%>> 
    </div>
  </div>
  
  
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>