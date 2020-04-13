package tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.beans.Clients;

/**
 * Servlet implementation class Client
 */
@WebServlet( "/Client" )
public class Client extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_CLIENT       = "client";
    public static final String CHAMP_NOM        = "nomClient";
    public static final String CHAMP_PRENOM     = "prenomClient";
    public static final String CHAMP_NUMERO     = "numeroClient";
    public static final String CHAMP_ADRESSE    = "adresseClient";
    public static final String CHAMP_EMAIL      = "emailClient";

    public static final String VUE              = "/WEB-INF/afficherClient.jsp";

    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String nom = request.getParameter( CHAMP_NOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String numero = request.getParameter( CHAMP_NUMERO );

        Clients client = new Clients();

        client.setNomClients( nom );
        client.setPrenomClients( request.getParameter( CHAMP_PRENOM ) );
        client.setNumeroClients( numero );
        client.setEmailClients( request.getParameter( CHAMP_EMAIL ) );
        client.setAdresseClients( adresse );

        request.setAttribute( ATT_CLIENT, client );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        doGet( request, response );
    }

}
