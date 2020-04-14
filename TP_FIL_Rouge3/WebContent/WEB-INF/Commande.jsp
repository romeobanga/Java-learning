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
 <h3>Formulaire de création d'une commande</h3>
		<form id=commande action="<c:url value="/Commande" />" name="commande" method="post">
		<c:set var="client" value="${commande.client }" scope="request" />
		<c:import url="/inc/form_client.jsp"/>
		<fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled />

                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="<c:out value="${ commande.montantCommande}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['montantCommande']} </span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="<c:out value="${ commande.modePaiementCommande}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['modePaiementCommande']} </span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="<c:out value="${ commande.statusPaiementCommande}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['statutPaiementCommande']} </span>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="<c:out value="${ commande.modeLivraisonCommande}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['modeLivraisonCommande']} </span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="<c:out value="${ commande.statusLivraisonCommande}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['statutLivraisonCommande']} </span>
                    <br />
                </fieldset>
                <p class="info">${ form.resultat }</p>
		<input type="submit" value="Valider"  />
        <input type="reset" value="Remettre à zéro" /> <br /> 
		</form>
</div>
</body>
</html>