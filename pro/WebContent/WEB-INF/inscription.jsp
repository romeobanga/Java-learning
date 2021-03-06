<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="inc/form.css" />
    </head>
    <body>
        <form method="post" action="inscription"> <!-- method="post" ==> la methose doPost() est appelée -->
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="100" />
                <span class="erreur"> ${ erreurs['email']} </span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="50" />
                <span class="erreur"> ${ erreurs['motdepasse']} </span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="50" />
                <span class="erreur"> ${ erreurs['confirmation']} </span>
                <br />

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="<c:out value="${param.nom}"/>" size="20" maxlength="20" />
                <!-- <c:out value="${param.nom}"/> ==> permet d'eviter les failles XSS -->
                <span class="erreur"> ${ erreurs['nom']} </span>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                <p class="${empty erreurs ? 'succes' : 'erreur' }"> ${resultat }</p>
            </fieldset>
        </form>
    </body>
</html>