<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
<fieldset >
                   <legend>Informations client</legend>
                   <p class="info">${ message }</p>
                    <label for="nomClient">Nom    :<span class="requis">${ client.nomClients}</span></label>
                    <br />
                    
                    <label for="prenomClient">Prénom :<span class="requis">${ client.prenomClients}</span></label>
                    <br />
                    
                    <label for="numeroClient">Telephone: <span class="requis">${ client.numeroClients}</label>
                    <br />
                    
                    <label for="emailClient">Adresse E-mail:<span class="requis">${ client.emailClients}</span> </label>
                    <br />
                    
                    <label for="adresseClient">Adresse de livraison :<span class="requis">${ client.adresseClients}</label>
                    <br />
             </fieldset>   
</body>
</html>