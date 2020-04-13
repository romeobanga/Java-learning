<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
			<fieldset >
                   <legend>Informations </legend>
                   <p class="info">
                   <c:if test="${empty param.nom || empty param.prenom || empty paramValues.pays || empty param.autre}">
					 Attention il y a des champs vides
					</c:if><br />
					</p>
                    <label for="nom">Nom de famille   : <span class="requis">${param.nom }</span></label>
                    <br />
                    
                    <label for="prenom">Prénom : <span class="requis">${ param.prenom}</span></label>
                    <br />
                    
                    <label for="pays">Pays visités: <span class="requis"> 
                    <c:forEach var="listePays" items="${ paramValues.pays}" > <c:out value="${listePays}"/> </c:forEach>
                    
                    </span></label>
                    <br />
                    
                    <label for="autre">Les autres pays visités:<span class="requis">
                    <c:forTokens var="autrePays" items="${param.autre }" delims=","> <c:out value="${ autrePays}" /></c:forTokens>
                    </span> </label>
                    <br />
             </fieldset>
             
             <fieldset >
             			<legend>Autres methodes </legend><!-- Le nom du paramètre et sa valeur forme une Map -->
             			
             			<c:forEach var="parametre" items="${paramValues}"> 
             			 <label > <c:out value="${ parametre.key}" />  : <span class="requis">
             			 <c:choose>
             			 
             			  <c:when test="${ parametre.key == 'autre'}">
	             			  <c:if test="${! empty param.autre }">
		             			  <c:forTokens var="autrePays" items="${param.autre}" delims=",">
		             			  <c:out value="${ autrePays}" /> 
		             			  </c:forTokens>
	             			  </c:if>
             			 </c:when>
             			 <c:otherwise>
             			  	 <c:forEach var="value" items="${parametre.value}">
	             			 	<c:out value="${ value}" /> 
	             			  </c:forEach>
             			 </c:otherwise>
             			           			 
             			</c:choose>
             			</span></label>
             			<br />
             			</c:forEach>          
             </fieldset>
             
               
</body>
</html>