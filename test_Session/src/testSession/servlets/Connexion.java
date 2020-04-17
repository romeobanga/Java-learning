package testSession.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import testSession.beans.Utilisateur;
import testSession.form.formUtilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet( "/Connexion" )
public class Connexion extends HttpServlet {
    private static final long   serialVersionUID          = 1L;
    private static final String VUE_FORM                  = "/WEB-INF/connexion.jsp";
    private static final String VUE_SUCCES                = "/WEB-INF/accueil.jsp";
    private static final String ATT_FORM                  = "form";
    private static final String ATT_CONN                  = "utilisateur";
    private static final String ATT_SESSION_USER          = "sessionUtilisateur";
    /* Pour la gestion des cookies */
    public static final String  ATT_INTERVALLE_CONNEXIONS = "intervalleConnexions";
    public static final String  COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
    public static final String  FORMAT_DATE               = "dd/MM/yyyy HH:mm:ss";

    public static final String  CHAMP_MEMOIRE             = "memoire";
    public static final int     COOKIE_MAX_AGE            = 60 * 60 * 24 * 365;      // 1
                                                                                     // an

    public Connexion() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /* Tentative de récupération du cookie depuis la requête */
        String derniereConnexion = getValeurCookie( request, COOKIE_DERNIERE_CONNEXION );
        /* Si le cookie existe, alors calcul de la durée */

        if ( derniereConnexion != null ) {

            /* Récupération de la date courante */
            DateTime dtCourante = new DateTime();
            /* Récupération et formatage de la date présente dans le cookie */
            DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
            DateTime dtDerniereConnexion = formatter.parseDateTime( derniereConnexion );
            /*
             * Convertit derniereConnexion qui est au format texte en format
             * DateTime
             */

            /* Calcul de la durée de l'intervalle */
            Period periode = new Period( dtDerniereConnexion, dtCourante );
            /* Formatage de la periode */
            PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
                    .appendYears().appendSuffix( " an ", " ans " )
                    .appendMonths().appendSuffix( " mois " )
                    .appendDays().appendSuffix( " jour ", " jours " )
                    .appendHours().appendSuffix( " heure ", " heures " )
                    .appendMinutes().appendSuffix( " minute ", " minutes " )
                    .appendSeparator( "et " )
                    .appendSeconds().appendSuffix( " seconde", " secondes" )
                    .toFormatter();

            /* Ajout de l'intervalle en tant qu'attribut de la requête */
            String intervalleConnexions = periodFormatter.print( periode );
            request.setAttribute( ATT_INTERVALLE_CONNEXIONS, intervalleConnexions );

        }

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    /**
     * Méthode utilitaire gérant la récupération de la valeur d'un cookie donné
     * depuis la requête HTTP.
     */
    private static String getValeurCookie( HttpServletRequest request, String nom ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        formUtilisateur form = new formUtilisateur();
        Utilisateur utilisateur = form.ConnecterUtilisateur( request );

        /*
         * recuperation de la session depuis la requete ou creation si elle
         * n'existe pas
         */
        HttpSession session = request.getSession();

        /* envoie de la session sous forme d'attribut */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );

        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_CONN, utilisateur );

        /* Si et seulement si la case du formulaire est cochée */
        if ( request.getParameter( CHAMP_MEMOIRE ) != null ) {
            /* Récuperation de la date courante */
            DateTime dt = new DateTime();
            /* Formatage de la date et conversion en texte */
            DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
            String dateDerniereConnexion = dt.toString( formatter );
            /* Création du cookie, et ajout à la réponse HTTP */
            // dateDerniereConnexion = "16/04/2020 22:08:00";
            setCookie( response, COOKIE_DERNIERE_CONNEXION, dateDerniereConnexion, COOKIE_MAX_AGE );

        } else {
            /* Demande de suppression du cookie du navigateur */
            setCookie( response, COOKIE_DERNIERE_CONNEXION, "", 0 );
        }

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    /*
     * Méthode utilitaire gérant la création d'un cookie et son ajout à la
     * réponse HTTP.
     */
    private void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {
        Cookie cookie = new Cookie( nom, valeur );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

}
