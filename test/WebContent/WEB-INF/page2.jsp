<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 2</title>
</head>
<body>
 <p>Ceci est une page générée depuis une JSP avec des EL</p>
        <p>
        Récupération de l'attribut : <br />
            ${requestScope.test} <br /><!-- Récuperation de l'attribut test de portée requete (recommandé), sans l'objet implicite requestScope, 
            il aurait cherché dans les 4 portées -->
            Récupération du paramètre : <br />
            ${param.auteur} <!-- Récuperation du paramètre auteur -->
        </p>
        <p>
            Récupération du bean :
            ${auteur.prenom}
            ${auteur.nom}
        </p>
</body>
</html>