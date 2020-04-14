package tp.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import tp.beans.Clients;

/**
 * @author romeo.banga
 *
 */
public class CreationClient {

    /* Recupération des noms des champs */
    private static final String CHAMP_NOM     = "nomClient";
    private static final String CHAMP_PRENOM  = "prenomClient";
    private static final String CHAMP_NUMERO  = "numeroClient";
    private static final String CHAMP_EMAIL   = "emailClient";
    private static final String CHAMP_ADRESSE = "adresseClient";
    private static final String ATT_RESULTAT  = "resultat";
    private static final String ATT_ERREURS   = "erreurs";
    private String              resultat;
    private Map<String, String> erreurs       = new HashMap<String, String>(); // Recupère
                                                                               // la
                                                                               // liste
                                                                               // des
                                                                               // erreurs

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
        erreurs.put( champ, message );// insere le couple nom du champ/erreur
                                      // dans le Map
    }

    public Clients CreerClient( HttpServletRequest request ) { /*
                                                                * Traitement du
                                                                * formulaire
                                                                * Client
                                                                */
        /* Recupère les valeurs des champs */
        String nomClient = getValeurChamp( request, CHAMP_NOM );
        String prenomClient = getValeurChamp( request, CHAMP_PRENOM );
        String numeroClient = getValeurChamp( request, CHAMP_NUMERO );
        String emailClient = getValeurChamp( request, CHAMP_EMAIL );
        String adresseClient = getValeurChamp( request, CHAMP_ADRESSE );

        Clients client = new Clients();

        try {
            validationNom( nomClient );
        } catch ( Exception e ) {
            setErreurs( CHAMP_NOM, e.getMessage() );
        }

        client.setNomClients( nomClient ); // Attribuer le nom du client au bean

        try {
            validationPrenom( prenomClient );
        } catch ( Exception e ) {
            setErreurs( CHAMP_PRENOM, e.getMessage() );
        }

        client.setPrenomClients( prenomClient );

        try {
            validationNumero( numeroClient );
        } catch ( Exception e ) {
            setErreurs( CHAMP_NUMERO, e.getMessage() );
        }

        client.setNumeroClients( numeroClient );

        try {
            validationEmail( emailClient );
        } catch ( Exception e ) {
            setErreurs( CHAMP_EMAIL, e.getMessage() );
        }

        client.setEmailClients( emailClient );

        try {
            validationAdresse( adresseClient );
        } catch ( Exception e ) {
            setErreurs( CHAMP_ADRESSE, e.getMessage() );
        }

        client.setAdresseClients( adresseClient );

        if ( erreurs.isEmpty() )
            setResultat( "La création a été effectuée avec succès." );
        else
            setResultat( "Echec de la création." );

        return client;

    }

    public static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        /*
         * Recupère le contenu du champ
         */
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else
            return valeur;
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom == null ) {
            throw new Exception( "Merci de saisir le nom" );
        } else if ( nom != null && nom.trim().length() < 3 ) {
            throw new Exception( "Le nom doit être de plus de 2 caractères !!" );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom == null ) {
            throw new Exception( "Merci de saisir le nom" );
        } else if ( prenom != null && prenom.trim().length() < 3 ) {
            throw new Exception( "Le prenom doit être de plus de 2 caractères !!" );
        }
    }

    private void validationNumero( String numero ) throws Exception {
        if ( numero == null ) {
            throw new Exception( "Merci de saisir le telephone" );
        } else if ( numero != null && numero.trim().length() < 4 ) {
            throw new Exception( "Le numéro doit contenir au moins 4 caractères !!" );
        }
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

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse == null ) {
            throw new Exception( "Merci de saisir l'adresse" );
        } else if ( adresse != null && adresse.trim().length() < 10 ) {
            throw new Exception( "L'adresse doit être de plus de 10 caractères !!" );
        }
    }

}
