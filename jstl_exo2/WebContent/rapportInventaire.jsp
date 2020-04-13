
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livres</title>
</head>
<body>
<c:import url="inventaire.xml" varReader="monReader">
 <x:parse var="doc" doc="${monReader}" ></x:parse>
 
 <x:forEach var="element" select="$doc/inventaire/livre">
 
 	<x:choose>
		<x:when select="$element[stock<minimum]">
		 <strong> Livre de titre : <x:out select="$element/titre" /></strong> <br/>
		       <strong>Auteur: </strong><x:out select="$element/auteur" /> <br/>
		       <strong>Date de publication: </strong><x:out select="$element/date" /><br/> 
		       <strong>Prix: </strong><x:out select="$element/prix" /><br/>
		       <strong>Nombre en stock: </strong><x:out select="$element/stock" /><br/>
		       <strong>Quantité minimum: </strong><x:out select="$element/minimum" /><br/>
		<i>Attention le stock du livre: <x:out select="$element/titre" />  est inferieur à la quantité minimum </i><br/>
		</x:when>
		 <x:otherwise>
		      <strong> Livre de titre : <x:out select="$element/titre" /></strong> <br/>
		       <strong>Auteur: </strong><x:out select="$element/auteur" /> <br/>
		       <strong>Date de publication: </strong><x:out select="$element/date" /><br/> 
		       <strong>Prix: </strong><x:out select="$element/prix" /><br/>
		       <strong>Nombre en stock: </strong><x:out select="$element/stock" /><br/>
		       <strong>Quantité minimum: </strong><x:out select="$element/minimum" /><br/>
		      
		 </x:otherwise>		   
	 </x:choose>  

 </x:forEach>

</c:import>
</body>
</html>