package pro.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import pro.beans.Utilisateurs;

public class InscriptionForm {

    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_MDP    = "motdepasse";
    private static final String CHAMP_CMPD   = "confirmation";
    private static final String CHAMP_NOM    = "nom";
    private static final String ATT_RESULTAT = "resultat";
    private static final String ATT_ERREURS  = "erreurs";
    String                      resultat;
    Map<String, String>         erreurs      = new HashMap<String, String>();

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

    public Utilisateurs inscrireUtilisateur( HttpServletRequest request ) {

        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_MDP );
        String confirmation = getValeurChamp( request, CHAMP_CMPD );
        String nom = getValeurChamp( request, CHAMP_NOM );

        Utilisateurs utilisateur = new Utilisateurs();

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreurs( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreurs( CHAMP_MDP, e.getMessage() );
            setErreurs( CHAMP_CMPD, null );
        }
        utilisateur.setMotdepasse( motDePasse );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreurs( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail( String mails ) throws Exception {
        if ( mails != null && mails.trim().length() != 0 ) {
            if ( !mails.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    private void validationMotsDePasse( String motDePasse, String confirmations ) throws Exception {
        if ( motDePasse != null && motDePasse.trim().length() != 0 && confirmations != null
                && confirmations.trim().length() != 0 ) {
            if ( !motDePasse.equals( confirmations ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.trim().length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void validationNom( String noms ) throws Exception {
        if ( noms != null && noms.trim().length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

}
