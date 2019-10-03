<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SocialDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Social</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>
<div class="main">

<%SocialDTO u = (SocialDTO) request.getAttribute("dto");%>


<form id="floatleft" action="SocialServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="id">Url</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="url" value=<%=u.getUrl()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Post</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="post" value=<%=u.getPost()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Data</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="data" value=<%=u.getData()%>> 
    </div>
      <div class="row">
    <div class="col-25">
     <label for="pass">Namecoin</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="namecoin" value=<%=u.getNamecoin()%>> 
    </div>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>