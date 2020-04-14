<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
</head>
<body>
<c:import url="/inc/menu.jsp"/>
<div id="corps">

                   <legend>Informations client</legend>
                  
                    <label for="nomClient">Nom    :<span class="requis"> <c:out value="${ commande.client.nomClients}" /></span></label>
                    <br />
                    
                    <label for="prenomClient">Prénom :<span class="requis"> <c:out value="${ commande.client.prenomClients}" /></span></label>
                    <br />
                    
                    <label for="numeroClient">Telephone: <span class="requis"><c:out value="${ commande.client.numeroClients} " /></span></label>
                    <br />
                    
                    <label for="emailClient">Adresse E-mail:<span class="requis"> <c:out value="${ commande.client.emailClients}" /></span> </label>
                    <br />
                    
                    <label for="adresseClient">Adresse de livraison :<span class="requis"> <c:out value="${ commande.client.adresseClients}" /></span></label>
                    <br />
</fieldset>   
<fieldset >
                   <legend>Informations commande</legend>
                  
                    <label for="nomClient">Date de Commande    :<span class="requis"> <c:out value="${ commande.dateCommande}" /></span></label>
                    <br />
                    
                    <label for="prenomClient">Montant :<span class="requis"><c:out value="${ commande.montantCommande}" /></span></label>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement: <span class="requis"><c:out value="${ commande.modePaiementCommande} " /></span></label>
                    <br />
                    
                    <label for="emailClient">Status de paiement:<span class="requis"><c:out value="${ commande.statusPaiementCommande}" /></span> </label>
                    <br />
                    
                    <label for="adresseClient">Mode de livraison :<span class="requis"><c:out value="${ commande.modeLivraisonCommande}" /> </span></label>
                    <br />
                    
                    <label for="adresseClient">Status de livraison :<span class="requis"><c:out value="${ commande.statusLivraisonCommande}" /></span></label>
                    <br />
                    
             </fieldset> 
 <p class="info">${ form.resultat }</p>
 </div>
</body>
</html>