<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.CoinDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>
<%@include file="menu/menu.jsp"%>



<div class="main">
<h1>Buongiorno ${user.getUsername()}</h1>

"Questo progetto calcola la previsione di una Cryptovaluta basandosi sull'andamento della stessa"

</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>