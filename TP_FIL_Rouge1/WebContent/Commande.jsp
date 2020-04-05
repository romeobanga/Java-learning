<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Commande</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
		<div>
        <h3>Formulaire de création d'une commande</h3>
		<form id=client action="Commande" name="client" method="get">
		<fieldset >
                   <legend>Informations client</legend>
                   
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="numeroClient">Telephone <span class="requis">*</label>
                    <input type="text" id="numeroClient" name="numeroClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailClient">Adresse E-mail </label>
                    <input type="text" id="emailClient" name="emailClient" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</label>
                    <input type="text" id=adresseClient name="adresseClient" value="" size="20" maxlength="100" />
                    <br />
             </fieldset>       
 		<fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled />
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="20" maxlength="20" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br /> 
             
         </form>          
            
        </div>
</body>
</html>