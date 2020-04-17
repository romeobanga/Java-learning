package testSession.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import testSession.beans.Utilisateur;

public class formUtilisateur {

    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_MDP   = "motdepasse";
    private Map<String, String> erreurs     = new HashMap<String, String>();
    private String              resultat;

    public String getResultat() {
        return resultat;
    }

    public void setResultat( String resultat ) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs( String champ, String message ) {
        // this.erreurs = erreurs;
        erreurs.put( champ, message );
    }

    public Utilisateur ConnecterUtilisateur( HttpServletRequest request ) {

        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_MDP );

        Utilisateur utilisateur = new Utilisateur();

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreurs( CHAMP_EMAIL, e.getMessage() );
        }

        utilisateur.setEmail( email );

        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreurs( CHAMP_MDP, e.getMessage() );
        }

        utilisateur.setMotDePasse( motDePasse );

        if ( erreurs.isEmpty() ) {
            setResultat(
                    "Connexion effectuée avec succès." );
        } else {
            setResultat( "Echec de la connexion." );
        }

        return utilisateur;
    }

    private String getValeurChamp( HttpServletRequest request, String nomChamp ) {

        String valeur = request.getParameter( nomChamp );

        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else
            return valeur;
    }

    private void validationEmail( String mails ) throws Exception {

        if ( mails != null && mails.trim().length() != 0 ) {
            if ( !mails.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationMotDePasse( String motDePasse ) throws Exception {

        if ( motDePasse != null && motDePasse.trim().length() != 0 ) {
            if ( motDePasse.trim().length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

}
