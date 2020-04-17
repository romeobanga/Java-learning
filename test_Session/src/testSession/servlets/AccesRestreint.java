package testSession.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccesRestreint
 */
@WebServlet( "/AccesRestreint" )
public class AccesRestreint extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String ACCES_PUBLIC     = "/accesPublic.jsp";
    public static final String ACCES_RESTREINT  = "/WEB-INF/accesRestreint.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    public AccesRestreint() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        HttpSession session = request.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null )
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        else
            this.getServletContext().getRequestDispatcher( ACCES_RESTREINT ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
