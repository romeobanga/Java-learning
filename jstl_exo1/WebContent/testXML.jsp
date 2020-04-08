<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="monDocument.xml" varReader="monReader"><!-- balise jstl qui importe le fichie, monReader (une variable) réçoit le fichier monDocument.xml brut  -->
   <%-- Parse le contenu du fichier XML monDocument.xml dans une variable nommée 'doc'  --%>
   <x:parse var="doc" doc="${monReader}" ></x:parse>
   <x:out select="$doc/news/article/auteur" ></x:out>
   <!-- sélectionner tous les nœuds "auteur" qui sont enfants d'un nœud "article" lui-même enfant du nœud racine "news" présent dans le document $doc -->

	<!-- Affiche les auteurs et titres de tous les articles -->
	<p>
	<x:forEach var="element" select="$doc/news/article">
	<x:choose>
		<x:when select="$element[auteur='Paul']">
		 Paul a déjà posté une news dont voici le titre : <x:out select="$doc/news/article[auteur='Paul']/titre" ></x:out><br/>
		</x:when>
		 <x:otherwise>
		      <strong><x:out select="$element/auteur" /></strong> : <x:out select="$element/titre" />.<br/>
		 </x:otherwise>		   
	 </x:choose>  
	</x:forEach>
	</p>
	
	<x:out select="$doc/news/article[@id=$param:idArticle]"></x:out>
		
		
<%-- Enregistre le résultat de l'expression XPath, spécifiée dans l'attribut select, 
dans une variable de session nommée 'auteur' --%>
<x:set var="auteur" scope="session" select="$doc//auteur" ></x:set>

<%-- Affiche le contenu de la variable nommée 'auteur' enregistrée en session --%>
<x:out select="$sessionScope:auteur" ></x:out>


</c:import>

<!-- formater un contenu XML en HTML -->
<c:import varReader="xslFile" url="monDocument.xsl">
<c:import varReader="xmlFile" url="monDocument.xml">
	<x:transform doc="${xmlFile}" xslt="${xslFile}"></x:transform>
</c:import>
</c:import>
</body>
</html>


<!-- Sélection du nœud racine -->
<!-- / -->

<!-- Sélection des nœuds 'article' enfants des nœuds 'news' -->
<!-- /news/article -->

<!-- Sélection de tous les nœuds inclus dans les nœuds 'article' enfants des nœuds 'news' -->
<!-- /news/article/* -->

<!-- Sélection de tous les nœuds 'auteur' qui ont deux parents quelconques -->
<!-- /*/*/auteur -->

<!-- Sélection de tous les nœuds 'auteur' du document via l'opérateur '//' -->
<!-- //auteur -->

<!-- Sélection de tous les nœuds 'article' ayant au moins un parent -->
<!-- /*//article -->

<!-- Sélection de l'attribut 'id' des nœuds 'article' enfants de 'news' -->
<!-- /news/article/@id -->

<!-- Sélection des nœuds 'article' enfants de 'news' dont la valeur du nœud 'auteur' est 'Paul' -->
<!-- /news/article[auteur='Paul'] -->

<!-- Sélection des nœuds 'article' enfants de 'news' dont l'attribut id vaut '12' -->
<!-- /news/article[@id='12'] -->



