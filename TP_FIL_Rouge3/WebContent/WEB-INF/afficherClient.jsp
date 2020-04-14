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

<c:if test="${empty formClient.erreurs}" > <c:out value=" Pas d'erreurs"></c:out> </c:if>
<c:import url="/inc/menu.jsp"/>
<div id="corps">
<fieldset >
                   <legend>Informations client</legend>
                  
	                   		<label for="nomClient">Nom    :<span class="requis"><c:out value="${ client.nomClients}" /></span></label>
	                   		
	                    	<br />
	                    
	                    	<label for="prenomClient">Prénom :<span class="requis"> <c:out value="${ client.prenomClients}" /></span></label>
	                    	<br />
	                    
	                    	<label for="numeroClient">Telephone: <span class="requis"> <c:out value="${ client.numeroClients}" /></label>
	                    	<br />
	                    
	                    	<label for="emailClient">Adresse E-mail:<span class="requis"> <c:out value="${ client.emailClients}" /></span> </label>
	                   	 	<br />
	                    
	                    	<label for="adresseClient">Adresse de livraison :<span class="requis"> <c:out value="${ client.adresseClients}" /></label>
	                    	<br />
                
             </fieldset>  
             </div>
         <p class="info">${ form.resultat }</p>     
</body>
</html>