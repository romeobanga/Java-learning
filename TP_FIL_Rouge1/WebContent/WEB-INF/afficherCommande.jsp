<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher Commande</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
<fieldset >
                   <legend>Informations client</legend>
                   <p class="info">${ message }</p>
                    <label for="nomClient">Nom    :<span class="requis">${ commande.client.nomClients}</span></label>
                    <br />
                    
                    <label for="prenomClient">Prénom :<span class="requis">${ commande.client.prenomClients}</span></label>
                    <br />
                    
                    <label for="numeroClient">Telephone: <span class="requis">${ commande.client.numeroClients}</label>
                    <br />
                    
                    <label for="emailClient">Adresse E-mail:<span class="requis">${ commande.client.emailClients}</span> </label>
                    <br />
                    
                    <label for="adresseClient">Adresse de livraison :<span class="requis">${ commande.client.adresseClients}</label>
                    <br />
</fieldset>   
<fieldset >
                   <legend>Informations commande</legend>
                  
                    <label for="nomClient">Date de Commande    :<span class="requis">${ commande.dateCommande}</span></label>
                    <br />
                    
                    <label for="prenomClient">Montant :<span class="requis">${ commande.montantCommande}</span></label>
                    <br />
                    
                    <label for="numeroClient">Mode de paiement: <span class="requis">${ commande.modePaiementCommande}</label>
                    <br />
                    
                    <label for="emailClient">Status de paiement:<span class="requis">${ commande.statusPaiementCommande}</span> </label>
                    <br />
                    
                    <label for="adresseClient">Mode de livraison :<span class="requis">${ commande.modeLivraisonCommande}</label>
                    <br />
                    
                    <label for="adresseClient">Status de livraison :<span class="requis">${ commande.statusLivraisonCommande}</label>
                    <br />
             </fieldset>   
</body>
</html>