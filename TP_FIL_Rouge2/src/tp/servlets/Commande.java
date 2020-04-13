package tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import tp.beans.Clients;
import tp.beans.Commandes;

/**
 * Servlet implementation class Commande
 */
@WebServlet( "/Commande" )
public class Commande extends HttpServlet {
    private static final long  serialVersionUID       = 1L;

    public static final String ATT_COMMANDE           = "commande";
    public static final String CHAMP_NOM              = "nomClient";
    public static final String CHAMP_PRENOM           = "prenomClient";
    public static final String CHAMP_NUMERO           = "numeroClient";
    public static final String CHAMP_ADRESSE          = "adresseClient";
    public static final String CHAMP_EMAIL            = "emailClient";
    public static final String CHAMP_MONTANT          = "montantCommande";
    public static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    public static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    public static final String CHAMP_STATUS_PAIEMENT  = "statutPaiementCommande";
    public static final String CHAMP_STATUS_LIVRAISON = "statutLivraisonCommande";
    public static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";
    public static final String VUE                    = "/WEB-INF/afficherCommande.jsp";

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

        String nom = request.getParameter( CHAMP_NOM );
        String numero = request.getParameter( CHAMP_NUMERO );
        String adresse = request.getParameter( CHAMP_ADRESSE );

        String montantC = request.getParameter( CHAMP_MONTANT );
        String modePaiement = request.getParameter( CHAMP_MODE_PAIEMENT );
        String modeLivraison = request.getParameter( CHAMP_MODE_LIVRAISON );
        String statusPaiement = request.getParameter( CHAMP_STATUS_PAIEMENT );
        String statusLivraison = request.getParameter( CHAMP_STATUS_LIVRAISON );

        double montant;

        try {
            montant = Double.parseDouble( montantC );

        } catch ( NumberFormatException e ) {
            montant = -1;
        }

        DateTime dt = new DateTime();

        DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT_DATE );
        String date = dt.toString( formatter );

        Clients client = new Clients();

        client.setNomClients( nom );
        client.setPrenomClients( request.getParameter( CHAMP_PRENOM ) );
        client.setNumeroClients( numero );
        client.setAdresseClients( adresse );
        client.setEmailClients( request.getParameter( CHAMP_EMAIL ) );

        Commandes commande = new Commandes();

        commande.setClient( client );
        commande.setDateCommande( date );
        commande.setModePaiementCommande( modePaiement );
        commande.setStatusPaiementCommande( statusPaiement );
        commande.setModeLivraisonCommande( modeLivraison );
        commande.setStatusLivraisonCommande( statusLivraison );
        commande.setMontantCommande( montant );

        request.setAttribute( ATT_COMMANDE, commande );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
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
