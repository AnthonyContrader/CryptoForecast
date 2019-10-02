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

"Questo progetto calcola la previsione di una Cryptovaluta basandosi sull'andamento della stessa
Le crittovalute (o criptovalute) utilizzano tecnologie di tipo peer-to-peer (p2p) su reti i cui 
nodi risultano costituiti da computer di utenti, situati potenzialmente in tutto il globo. Su questi 
computer vengono eseguiti appositi programmi che svolgono funzioni di portamonete. Non c'� attualmente 
alcuna autorit� centrale che le controlla. Le transazioni e il rilascio avvengono collettivamente in rete, 
pertanto non c'� una gestione di tipo "centralizzato". Queste propriet� uniche nel loro genere, 
non possono essere esplicate dai sistemi di pagamento tradizionale."

</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>