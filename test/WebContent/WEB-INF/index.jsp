<%@page import="test.beans.Auteur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<h1>Première page JSP réussie</h1>
<body>
<p>
<% //balise JSP 
 String attribut1 = (String) request.getAttribute("test");// Recuperation de l'attribut, on convertit car getAttribute renvoie un objet de type Object
 out.println(attribut1);
 //String attribut2 = (String) request.getAttribute("param1");
// out.println("Tranmission de paramètre Auteur: " + attribut2);
 %>
</p>

<p>
Recupération du bean :
<%
 Auteur auteur = (Auteur) request.getAttribute("auteur");

out.println(auteur.getNom());
out.println(auteur.getPrenom());
out.println(auteur.isActif()); 
%>
</p>

<p>
<jsp:useBean id="auteur2" class="test.beans.Auteur" />
<%-- le texte qui est présent entre les balises ne sera affiché que si un bean est bel et bien créé, 
autrement dit si la balise <jsp> est appelée avec succès.À l'inverse, si un bean du même nom existe déjà dans cette page, 
alors le bean sera simplement récupéré et le texte ne sera pas affiché. --%>

   <p>Nouveau bean !</p>
<%-- <jsp:setProperty name="auteur2" property="prenom" value="Anael" /> --%>
<jsp:getProperty name="auteur2" property="prenom" />
<%-- L'action suivante affiche le contenu de la propriété 'prenom' du bean 'Auteur' : --%>
<jsp:getProperty name="auteur2" property="nom"    />

<jsp:setProperty name="auteur2" property="nom" param="nom"/>
<jsp:setProperty name="auteur2" property="nom"/>
<jsp:getProperty name="auteur2" property="nom"    />
<%-- L'action suivante associe directement la valeur récupérée
depuis le paramètre de la requête nommé ici 'nom' à la propriété 'prenom' : --%>

<jsp:setProperty name="auteur2" property="*" />
<%-- L'action suivante associe automatiquement la valeur récupérée
depuis chaque paramètre de la requête à la propriété de même nom : --%>
<jsp:getProperty name="auteur2" property="nom"    />
<jsp:getProperty name="auteur2" property="prenom"    />

</p>

</body>
</html>