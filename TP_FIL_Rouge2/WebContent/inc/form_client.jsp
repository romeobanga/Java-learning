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
</body>
</html>