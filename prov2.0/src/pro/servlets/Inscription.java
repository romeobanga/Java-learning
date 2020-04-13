package pro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.beans.Utilisateur;
import pro.form.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
@WebServlet( name = "Inscriptions", urlPatterns = { "/Inscriptions" } )
public class Inscription extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    public static final String  VUE              = "/WEB-INF/inscription.jsp";
    private static final String ATT_FORM         = "form";
    private static final String ATT_USER         = "utilisateur";

    public Inscription() {
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
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        InscriptionForm form = new InscriptionForm();

        Utilisateur utilisateur = form.inscrireUtilisateur( request );

        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        // doGet( request, response ); Pas recommander dans les best pratice
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        doGet( request, response );
    }

}
