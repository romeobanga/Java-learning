<%-- <%@ page isELIgnored ="true" %>  --%><!-- désactive l'évaluation des EL dans les anciennes version de JSP -->
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 1</title>
</head>
<body>
<h1> Allo !!! Ici la page 1 </h1>
<h2> On va enfin passer aux choses sérieuses hihihihihih !!!</h2>
<h2> ------------------------------------------------------------------------------</h2>

<p>
        <!-- Logiques sur des booléens -->
        ${ true && true } <br /> <!-- Affiche true -->
        ${ true && false } <br /> <!-- Affiche false -->
        ${ !true || false } <br /> <!-- Affiche false -->
		
        <!-- Calculs arithmétiques -->
        ${ 10 / 4 } <br /> <!-- Affiche 2.5 -->
        ${ 10 mod 4 } <br /> <!-- Affiche le reste de la division entière, soit 2 -->
        ${ 10 % 4 } <br /> <!-- Affiche le reste de la division entière, soit 2 -->
        ${ 6 * 7 } <br /> <!-- Affiche 42 -->
        ${ 63 - 8 } <br /> <!-- Affiche 55 -->
        ${ 12 / -8 } <br /> <!-- Affiche -1.5 -->
        ${ 7 / 0 } <br /> <!-- Affiche Infinity -->
		
        <!-- Compare les caractères 'a' et 'b'. Le caractère 'a' étant bien situé avant le caractère 'b' dans l'alphabet ASCII, cette EL affiche true. -->
        ${ 'a' < 'b' } <br />  
		
        <!-- Compare les chaînes 'hip' et 'hit'. Puisque 'p' < 't', cette EL affiche false. -->
        ${ 'hip' gt 'hit' } <br /> 
		
        <!-- Compare les caractères 'a' et 'b', puis les chaînes 'hip' et 'hit'. Puisque le premier test renvoie true et le second false, le résultat est false. -->
        ${ 'a' < 'b' && 'hip' gt 'hit' } <br /> 
		
        <!-- Compare le résultat d'un calcul à une valeur fixe. Ici, 6 x 7 vaut 42 et non pas 48, le résultat est false. -->
        ${ 6 * 7 == 48 } <br /> 
        
        <!-- Vérifications si vide ou null -->
		${ empty 'test' } <br /> <!-- La chaîne testée n'est pas vide, le résultat est false -->
		${ empty '' } <br /> <!-- La chaîne testée est vide, le résultat est true -->
		${ !empty '' } <br /> <!-- La chaîne testée est vide, le résultat est false -->
		
		<!-- Conditions ternaires -->
		${ true ? 'vrai' : 'faux' } <br /> <!-- Le booléen testé vaut true, vrai est affiché -->
		${ 'a' > 'b' ? 'oui'  : 'non' } <br /> <!-- Le résultat de la comparaison vaut false, non est affiché -->
		${ empty 'test' ? 'vide' : 'non  vide'  } <br /> <!-- La chaîne testée n'est pas vide, non vide est affiché -->
		
		<!-- La ligne suivante : -->
		<p>12 est inférieur à 8 : ${ 12 lt 8 }.</p>
		${'-------------------------------------------------------------------------------' }
    </p>
				
		
		    <p>
        <!-- Initialisation d'un bean de type Coyote avec une action standard, pour l'exemple : -->
        <jsp:useBean id="auteur" class="test.beans.Auteur" />
        <!-- Initialisation de sa propriété 'prénom' : -->
        <jsp:setProperty name="auteur" property="prenom"/>
        <!-- Et affichage de sa valeur : -->
         ${empty auteur.prenom ? 'Veuillez donner ue valeur au paramètre prenom dans l"URL' : auteur.prenom  } 
       <%--  ${auteur.prenom } --%>
    </p>
    
     <p>
       <%
         Map<String, String> aliments = new HashMap<String, String>();
         aliments.put( "pomme","fruit" );
         aliments.put( "carotte","légume" );
         aliments.put( "boeuf","viande" );
         aliments.put( "aubergine","légume" );
         request.setAttribute( "aliments", aliments );
       %>
       ${ aliments.pomme } <br /> <!-- affiche fruit -->
       ${ aliments.carotte } <br /> <!-- affiche légume -->
       ${ aliments.boeuf } <br /> <!-- affiche viande -->
       ${ aliments.aubergine } <br /><!-- affiche légume -->
    </p>
    <p>Test des objets implicites EL </p>
    <p> <!--  Paramètres -->
	Langue : ${ paramValues.langue[1] }
	<br />
	Article : ${ param.article }
    </p>
</body>
</html>