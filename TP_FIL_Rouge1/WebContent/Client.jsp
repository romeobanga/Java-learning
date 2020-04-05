<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Cette page affiche un formulaire permettant la saisie d'informations sur le Client -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
        <h3>Formulaire de création d'un Client</h3>
		<form id=client action="Client" name="client" method="get"> <!-- action="Client" => A la validation, la servlet Client est lancée  -->
		<!-- La methode get envoie les paramètres au servlet en passant par l'URL -->
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
                   <input type="submit" id="submit"    value="Valider" />  
                   <input type="reset"  id="reset"     value="Reinitialiser" /> 
                   
            
         </form>          
            
        </div>
    </body>
</html>