<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset >
                   <legend>Informations client</legend>
                   
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nomClient" value="<c:out value="${ client.nomClients}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['nomClient']} </span>
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="<c:out value="${ client.prenomClients}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['prenomClient']} </span>
                    <br />
                    
                    <label for="numeroClient">Telephone <span class="requis">*</label>
                    <input type="number" id="numeroClient" name="numeroClient" value="<c:out value="${ client.numeroClients}" />" size="20" maxlength="20" />
                     <span class="erreur"> ${ form.erreurs['numeroClient']} </span>
                    <br />
                    
                    <label for="emailClient">Adresse E-mail </label>
                    <input type="text" id="emailClient" name="emailClient" value="<c:out value="${ client.emailClients}" />" size="20" maxlength="20" />
                    <span class="erreur"> ${ form.erreurs['emailClient']} </span>
                    <br />
                    
                    <label for="adresseClient">Adresse de livraison <span class="requis">*</label>
                    <input type="text" id=adresseClient name="adresseClient" value="<c:out value="${ client.adresseClients}" />" size="20" maxlength="100" />
                    <span class="erreur"> ${ form.erreurs['adresseClient']} </span>
                    <br />
             </fieldset> 
</body>
</html>