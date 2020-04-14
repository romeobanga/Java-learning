package tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.beans.Commandes;
import tp.form.CreationCommande;

/**
 * Servlet implementation class Commande
 */
@WebServlet( "/Commande" )
public class Commande extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String VUE_FORM         = "/WEB-INF/Commande.jsp";
    private static final String VUE_SUCCES       = "/WEB-INF/afficherCommande.jsp";
    private static final String ATT_FORM         = "form";
    private static final String ATT_COMMANDE     = "commande";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commande() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        CreationCommande form = new CreationCommande();

        Commandes commande = form.creationCommande( request );

        request.setAttribute( ATT_COMMANDE, commande );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() )
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        else
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );

    }

}
