package tp.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import tp.beans.Clients;
import tp.beans.Commandes;

public class CreationCommande {

    private static final String CHAMP_DATE             = "dateCommande";
    private static final String CHAMP_MONTANT          = "montantCommande";
    private static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    private static final String CHAMP_STATUS_PAIEMENT  = "statutPaiementCommande";
    private static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    private static final String CHAMP_STATUS_LIVRAISON = "statutLivraisonCommande";
    private static final String ATT_RESULTAT           = "resultat";
    private static final String ATT_ERREURS            = "erreurs";
    private String              resultat;
    private Map<String, String> erreurs                = new HashMap<String, String>();
    private static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";

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

    public Commandes creationCommande( HttpServletRequest request ) {

        String datePaiement = getValeurChamp( request, CHAMP_DATE );
        String montant = getValeurChamp( request, CHAMP_MONTANT );
        String modePaiement = getValeurChamp( request, CHAMP_MODE_PAIEMENT );
        String statusPaiement = getValeurChamp( request, CHAMP_STATUS_PAIEMENT );
        String modeLivraison = getValeurChamp( request, CHAMP_MODE_LIVRAISON );
        String statusLivraison = getValeurChamp( request, CHAMP_STATUS_LIVRAISON );

        CreationClient formClient = new CreationClient(); // recupère les champs

        Clients client = formClient.CreerClient( request ); // insère les
                                                            // données dans le
                                                            // bean client

        erreurs = formClient.getErreurs(); // recupere les erreurs du formulaire
                                           // client

        Commandes commande = new Commandes();

        commande.setClient( client );

        DateTime dt = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        String date = dt.toString( formatter );

        commande.setDateCommande( date );

        double valeurMontant = -1;

        try {
            valeurMontant = validationMontant( montant );
        } catch ( Exception e ) {
            setErreurs( CHAMP_MONTANT, e.getMessage() );
        }

        commande.setMontantCommande( valeurMontant );

        try {
            validationModePaiement( modePaiement );
        } catch ( Exception e ) {
            setErreurs( CHAMP_MODE_PAIEMENT, e.getMessage() );
        }

        commande.setModePaiementCommande( modePaiement );

        try {
            validationStatutPaiement( statusPaiement );
        } catch ( Exception e ) {
            setErreurs( CHAMP_STATUS_PAIEMENT, e.getMessage() );
        }

        commande.setStatusPaiementCommande( statusPaiement );

        try {
            validationModeLivraison( modeLivraison );
        } catch ( Exception e ) {
            setErreurs( CHAMP_MODE_LIVRAISON, e.getMessage() );
        }

        commande.setModeLivraisonCommande( modeLivraison );

        try {
            validationStatutLivraison( statusLivraison );
        } catch ( Exception e ) {
            setErreurs( CHAMP_STATUS_LIVRAISON, e.getMessage() );
        }

        commande.setStatusLivraisonCommande( statusLivraison );

        if ( erreurs.isEmpty() )
            setResultat( "La création a été effectuée avec succès." );
        else
            setResultat( "Echec de la création." );

        return commande;
    }

    private double validationMontant( String montant ) throws Exception {
        double temp;
        if ( montant != null ) {
            try {
                temp = Double.parseDouble( montant );
                if ( temp < 0 ) {
                    throw new Exception( "Le montant doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le montant doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un montant." );
        }
        return temp;
    }

    private void validationModePaiement( String modePaiement ) throws Exception {
        if ( modePaiement != null ) {
            if ( modePaiement.length() < 2 ) {
                throw new Exception( "Le mode de paiement doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de paiement." );
        }
    }

    private void validationStatutPaiement( String statutPaiement ) throws Exception {

        if ( statutPaiement == null ) {
            throw new Exception( "Merci de saisir le status de paiement" );
        } else if ( statutPaiement != null && statutPaiement.length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins 2 caractères." );
        }
    }

    private void validationModeLivraison( String modeLivraison ) throws Exception {
        if ( modeLivraison != null ) {
            if ( modeLivraison.length() < 2 ) {
                throw new Exception( "Le mode de livraison doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de livraison." );
        }
    }

    private void validationStatutLivraison( String statutLivraison ) throws Exception {

        if ( statutLivraison == null ) {
            throw new Exception( "Merci de saisir le status de livraison" );
        } else if ( statutLivraison != null && statutLivraison.length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins 2 caractères." );
        }
    }

    private String getValeurChamp( HttpServletRequest request, String champ ) {
        String valeur = request.getParameter( champ );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else
            return valeur;
    }

}
