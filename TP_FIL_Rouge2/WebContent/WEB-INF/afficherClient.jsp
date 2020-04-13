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
<fieldset >
                   <legend>Informations client</legend>
                   
                   <c:choose>
                   
                   		<c:when test="${empty client.nomClients  || empty client.numeroClients || empty client.adresseClients }"> 
                   			<p class="info">
                   			<c:out value="Erreur vous n'avez pas rempli tous les champs obligatoires."></c:out><br />
                   			<a href="<c:url value="/Client.jsp" />">Cliquez ici</a> pour accéder au formualaire de création d'un client<br/>
                   			</p>
                   		</c:when>
                   	
                   		<c:otherwise> 
                   		<p class="info">
                   		<c:out value="Client créé avec succès."></c:out><br />
                   		</p>
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
                   		</c:otherwise>
                   
                   </c:choose>
                  
                
    					
                    
             </fieldset>  
             </div>
             
</body>
</html>