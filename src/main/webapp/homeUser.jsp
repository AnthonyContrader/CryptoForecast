<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomeUser**</title>
</head>
<body>
<%@include file="/CSS/header.jsp"%>



  <div class="main mainContainer">
<h1>Benvenuto ${user.getUsername()}</h1>

"Questo progetto calcola la previsione di una Cryptovaluta basandosi sull'andamento della stessa"


</div>


<%@ include file="CSS/footer.jsp" %>
</body>
</html>