package testSession.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
@WebFilter( "/RestrictionFilter" )
public class RestrictionFilter implements Filter {

    // public static final String ACCES_PUBLIC = "/accesPublic.jsp";
    public static final String ACCES_CONNEXION  = "/connexion";
    /*
     * Dans le cas du blocage de l'appli toute entiere, on redirige vers la page
     * de connexion
     */

    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    /**
     * Default constructor.
     */
    public RestrictionFilter() {

    }

    public void destroy() {

    }

    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain )
            throws IOException, ServletException {

        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        /* Recuperation de la session depuis la requete */
        HttpSession session = request.getSession();

        /* Non-filtrage des ressources statiques -- fichier CSS, et autres */
        /*
         * Pour permettre à la page connexion de garder son design qui etait
         * bloqué au depart par le filtre
         */
        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
        /*
         * On applique une exception sur le dossier /inc afin qu'il ne soit pas
         * restreint aussi
         */
        if ( chemin.startsWith( "/inc" ) ) {
            chain.doFilter( request, response );
            return;
        }

        if ( session.getAttribute( ATT_SESSION_USER ) == null )
            /* Redirection vers la page publique */
            // response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
            /*
             * On utilise un forward par la redirection declenche un echange
             * infini entre le cleint et le filtre
             */
            request.getRequestDispatcher( ACCES_CONNEXION ).forward( request, response );
        else
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
    }

    public void init( FilterConfig fConfig ) throws ServletException {

    }

}
