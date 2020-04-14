<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
</head>
<body>
<c:import url="/inc/menu.jsp"/>
<div id="corps">
 <h3>Formulaire de création d'un client</h3>
		<form id=client action="<c:url value="/Client" />" name="client" method="post">
		<c:import url="/inc/form_client.jsp"/>
		 <p class="info">${ form.resultat }</p>
		<input type="submit" value="Valider"  />
        <input type="reset" value="Remettre à zéro" /> <br /> 
		</form>
</div>
</body>
</html>