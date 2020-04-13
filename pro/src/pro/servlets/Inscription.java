package pro.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/Inscription" )
public class Inscription extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String VUE              = "/WEB-INF/inscription.jsp";
    private static final String CHAMP_EMAIL      = "email";
    private static final String CHAMP_MDP        = "motdepasse";
    private static final String CHAMP_CMPD       = "confirmation";
    private static final String CHAMP_NOM        = "nom";
    private static final String ATT_RESULTAT     = "resultat";
    private static final String ATT_ERREURS      = "erreurs";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Traitement des données du formulaire */

        String email = request.getParameter( CHAMP_EMAIL );
        String motdepasse = request.getParameter( CHAMP_MDP );
        String confirmation = request.getParameter( CHAMP_CMPD );
        String nom = request.getParameter( CHAMP_NOM );
        String resultat; // Pour contenir le resultat de l'action Valider

        Map<String, String> erreurs = new HashMap<String, String>();
        /*
         * Contient un tableau avec comme clé les noms des champs et valeurs les
         * resulats des exceptions
         */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() ); // insertion dans le Map
        }

        try {
            validationMotsDePasse( motdepasse, confirmation );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_MDP, e.getMessage() );
        }

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription";
        } else {
            resultat = "Echec de l'inscription";
        }

        request.setAttribute( ATT_RESULTAT, resultat );
        request.setAttribute( ATT_ERREURS, erreurs );

        doGet( request, response );
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
}
