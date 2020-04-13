<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Une directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil JSTL</title>
</head>
<body>
<c:out value="test de l'affichage via la JSTL" /> <br />
<c:out value="${ 'a' < 'b' }" /> <!-- JSTL + EL --> <br />

<%-- Cette balise affichera le mot 'test' si le bean n'existe pas : --%>
<c:out value="${bean}">
la bean n'existe pas
</c:out> <br />

<%-- Elle peut également s'écrire sous cette forme : --%>
<c:out value="${bean}" default="la bean n'existe pas" /> <br />

<%-- Et il est interdit d'écrire : --%>
<%-- <c:out value="${bean}" default="test"> --%>
<!--     une autre chaine -->
<%-- </c:out> --%>

<%-- Sans préciser d'attribut escapeXml : --%>
<c:out value="<p>Je suis un élève brillant</p>" escapeXml="false" /> <!-- escapeXml="false" permet d'interpreter le code html   -->

<input type="text" name="donnee" value="<c:out value="${donneeSaisieParUnUtilisateur}"/>" /> <!-- permet la recuperation de données saisies depuis un formulaire -->

<%-- Cette balise met l'expression "Salut les zéros !" dans l'attribut "message" de la requête : --%>
<c:set var="message" value="Salut les zéros !" scope="request" /><br />

<%-- Affiche l'expression contenue dans la variable "message" de la requête --%>
<c:out value="${requestScope.message}" /> <br />

<c:set var="message" value="Salut les zéros ! Contenu de la variable modifiée" scope="request" /><br />
<c:out value="${requestScope.message}" /> <br />
<%--Cette instruction est pareille que celle ci-dessous--%>
<c:set var="message">
Salut les zéros ! Contenu de la variable modifiée par une autre instruction
</c:set>

<c:out value="${message}" /> <br />

<!-- Initialiser la valeur de la session : locale par la valeur du paramètre lang -->
<c:set var="locale" scope="session">
   <c:out value="${param.lang}" default="FR"/>
</c:set>
<c:out value="${locale}" /> <br />

<%-- Crée un objet de type String --%>
<c:set scope="session" var="description" value="Je suis une loutre." />

<%-- Crée un objet du type du bean ici spécifié dans l'attribut 'value'--%>
<c:set scope="session" var="tonBean" value="${monBean}" />

<!-- Définir ou modifier la propriété 'prenom' du bean 'coyote' -->
<%-- <c:set target="${coyote}" property="prenom" value="Wile E."/> --%>

<!-- Définir ou modifier la propriété 'prenom' du bean 'coyote' via le corps de la balise -->
<%-- <c:set target="${coyote}" property="prenom">
   Wile E.
</c:set> --%>

<!-- Passer à null la valeur de la propriété 'prenom' du bean 'coyote' -->
<%-- <c:set target="${coyote}" property="prenom" value="${null}" />
 --%>
<%-- Supprime la variable "tonBean" de la session --%>
<c:remove var="tonBean" scope="session" />
<c:out value="${tonBean }" default="La variable de session a été deleted"/><br />

<!-- Conditon if simple -->
<c:if test="${ 12 > 7 }" var="maVariable" scope="session"><!-- Le resultat du test va dans maVariable -->
 Ce test est vrai
</c:if><br />
<c:out value="${maVariable }" /><br />
 
 <!-- Condition if/else -->
 <c:choose>
    <c:when test="${maVariable=false}"> <c:out value="Le test est Vrai" /> </c:when>

    <c:otherwise> <c:out value="Le test est Faux" /></c:otherwise>
</c:choose><br />

<%-- Boucle for calculant le cube des entiers de 0 à 7 et les affichant dans un tableau HTML --%>
<table>
  <tr>
    <th>Valeur</th>
    <th>Cube</th>
  </tr>

<c:forEach var="i" begin="0" end="7" step="1">
  <tr>
    <td><c:out value="${i}"/></td>
    <td><c:out value="${i * i * i}"/></td>
  </tr>
</c:forEach>

</table>
<p>
<%-- Itération sur une chaîne de caractères: Affiche les différentes sous-chaînes séparées par une virgule ou un point-virgule --%>
<c:forTokens var="sousChaine" items="salut; je suis un,gros;zéro+!" delims=";,+" varStatus="status">
<div >
  Ligne n° <c:out value="${status.count}"/> : <!-- varStatus contient des proprietes sur la liste, 
  notamment begin, end, step, first, last, count, index, current -->
  ${sousChaine}<br/>
  </div>
</c:forTokens>
</p>

<%-- Génère une url simple, positionnée dans un lien HTML --%>
<a href="<c:url value="test.jsp" />">lien</a>

<%-- Génère une url et la stocke dans la variable lien --%>
<c:url value="test.jsp" var="lien" />
 </div>
<%-- Une URL générée de cette manière --%>
<a href="<c:url value="test.jsp"> <!-- Avec curl les paramètres passés sont encodés -->
  <c:param name="date" value="22/06/2010"/>
  <c:param name="donnees" value="des données contenant des c@r#ct%res bi&a**es..."/>
</c:url>">Lien HTML</a>

<%-- Redirection
La balise <c:redirect> est utilisée pour envoyer un message de redirection HTTP au navigateur de l'utilisateur --%>

<c:redirect url="http://www.siteduzero.com">
  <c:param name="mascotte" value="zozor"/>
  <c:param name="langue" value="fr"/>
</c:redirect>


</body>
</html>