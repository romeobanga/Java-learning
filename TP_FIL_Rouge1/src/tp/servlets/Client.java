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
    private static final long serialVersionUID = 1L;

    public Client() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String nom = request.getParameter( "nomClient" ); // Les paramètres sont
        // les noms des champs dans le formulaire
        // String prenom = request.getParameter("prenomClient");
        String adresse = request.getParameter( "adresseClient" );
        String numero = request.getParameter( "numeroClient" );
        Clients client = new Clients();

        client.setNomClients( nom );
        client.setPrenomClients( request.getParameter( "prenomClient" ) );
        client.setNumeroClients( numero );
        client.setEmailClients( request.getParameter( "emailClient" ) );
        client.setAdresseClients( adresse );

        String message;

        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || numero.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"Client.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        } else {
            message = "Client créé avec succès !";
        }

        request.setAttribute( "client", client );
        request.setAttribute( "message", message );

        this.getServletContext().getRequestDispatcher( "/WEB-INF/afficherClient.jsp" ).forward( request, response );

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
