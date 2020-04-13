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
<c:choose>
	<c:when test="${empty commande.client.nomClients  || empty commande.client.numeroClients || empty commande.client.adresseClients 
					|| empty commande.montantCommande || empty commande.modePaiementCommande || empty commande.modeLivraisonCommande}">
	<fieldset >
	<p class="info">
    <c:out value="Erreur vous n'avez pas rempli tous les champs obligatoires."></c:out><br />
    <a href="<c:url value="/Commande.jsp" />">Cliquez ici</a> pour accéder au formualaire de création d'un client<br/>
    </p>
    </fieldset>
	</c:when>
	
	<c:otherwise>
	<fieldset >
	<p class="info">
                   		<c:out value="Client créé avec succès."></c:out><br />
                   		</p>
                   <legend>Informations client</legend>
                   <p class="info">${ message }</p>
                    <label for="nomClient">Nom    :<span class="requis"> <c:out value="${ commande.client.nomClients}" /></span></label>
                    <br />
                    
                    <label for="prenomClient">Prénom :<span class="requis"> <c:out value="${ commande.client.prenomClients}" /></span></label>
                    <br />
                    
                    <label for="numeroClient">Telephone: <span class="requis"><c:out value="${ commande.client.numeroClients} " /></label>
                    <br />
                    
                    <label for="emailClient">Adresse E-mail:<span class="requis"> <c:out value="${ commande.client.emailClients}" /></span> </label>
                    <br />
                    
                    <label for="adresseClient">Adresse de livraison :<span class="requis"> <c:out value="${ commande.client.adresseClients}" /></label>
                    <br />
</fieldset>   
<fieldset >
                   <legend>Informations commande</legend>
                  
                    <label for="nomClient">Date de Commande    :<span class="requis"> <c:out value="${ commande.dateCommande}" /></span></label>
                    <br />
                    
                    <label for="prenomClient">Montant :<span class="requis"><c:out value="${ commande.montantCommande}" /></span></label>
                    <br />
                    
                    <label for="numeroClient">Mode de paiement: <span class="requis"><c:out value="${ commande.modePaiementCommande}" /></label>
                    <br />
                    
                    <label for="emailClient">Status de paiement:<span class="requis"><c:out value="${ commande.statusPaiementCommande}" /></span> </label>
                    <br />
                    
                    <label for="adresseClient">Mode de livraison :<span class="requis"><c:out value="${ commande.modeLivraisonCommande}" /></label>
                    <br />
                    
                    <label for="adresseClient">Status de livraison :<span class="requis"><c:out value="${ commande.statusLivraisonCommande}" /></label>
                    <br />
             </fieldset> 
	</c:otherwise>
</c:choose>
 </div>
</body>
</html>