<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CoinDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Coin</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<%@ include file="../menu/menu.jsp" %>

<br>
<div class="main">

<%CoinDTO u = (CoinDTO) request.getAttribute("dto");%>


<form idcoin="floatleft" action="UserServlet?mode=update&idcoin=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="coin">Name</label>
    </div>
    <div class="col-75">
      <input type="text" idcoin="coin" name="name" value=<%=u.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Quotation</label>
    </div>
    <div class="col-75">
      <input
			type="text" idccoin="pass" name="quotation" value=<%=u.getQuotation()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Symbol</label>
    </div>
   		 <div class="col-75">
 			<select idcoin="type" name="Symbol">
  				<%-- <option value="ADMIN" <%if(u.getUsertype().equals("ADMIN")) {%>selected<%}%>>ADMIN</option>
  				<option value="USER" <%if(u.getUsertype().equals("USER")) {%>selected<%}%>>USER</option> --%>
			</select>
    	</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>