<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Première page JSP réussie</h1>
<body>
<p>
<% //balise JSP
String attribut1 = (String) request.getAttribute("test");// Recuperation de l'attribut, on convertit car getAttribute renvoie un objet de type Object
out.println(attribut1);
String attribut2 = (String) request.getAttribute("param1");
out.println("Tranmission de paramètre Auteur: " + attribut2);


%>
</p>

</body>
</html>