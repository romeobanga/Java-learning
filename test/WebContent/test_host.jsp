<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%@ page import="java.util.ArrayList" %>
 <%@ include file="test_inc.jsp" %> 
 <%--Ici la classe importé agit sur le fichier importé car l'inclusion est réalisée au moment de la compilation --%>
<%--<jsp:include page="test_inc.jsp" /> --%>
<%-- Dans cette inclusion, la compilation des 2 pages se fait separement donc evidemment
la page test_inc.jsp echoue puisque la bibliothèque importée ici n'agit pas laba  car  l'inclusion est réalisée au moment de l'execution--%>
</p>
</body>
</html>