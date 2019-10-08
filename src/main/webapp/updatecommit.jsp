<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CommitDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Commit</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/commit/getall">Users</a>
  <a class="active" href="/user/getall">Commits</a>
  <a  href="/trend/getall">Trends</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CommitDTO u = (CommitDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/commit/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="coin">Stars</label>
    </div>
    <div class="col-75">
      <input type="text" id="commit" name="stars" value=<%=u.getStars()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="fork">Fork</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="fork" name="fork" value=<%=u.getFork()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Watcher</label>
    </div>
   		 <div class="col-75">
 			<input
			type="text" id="watc" name="watcher" value=<%=u.getWatcher()%>> 
    	</div>
   </div>
  <div class="row">
    <div class="col-25">
     <label for="coll">Collaborators</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="coll" name="collaborators" value=<%=u.getCollaborators()%>> 
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
    <input type="hidden" name="id" value =<%=u.getId() %>>  
    </div>
      <button type="submit" >Edit</button>
      
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>