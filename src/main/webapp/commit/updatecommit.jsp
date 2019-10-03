<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CommitDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Commit</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>
<div class="main">

<%CommitDTO u = (CommitDTO) request.getAttribute("dto");%>


<form id="floatleft" action="CommitServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="id">Namecoin</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="namecoin" value=<%=u.getNamecoin()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="numb">Number</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="numb" name="number" value=<%=u.getNumber()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Data</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="numb" name="data" value=<%=u.getData()%>> 
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>