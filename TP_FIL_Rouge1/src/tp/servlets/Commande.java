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
@WebServlet("/Commande")
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nomClient");
		//String prenom = request.getParameter("prenomClient");
		String numero = request.getParameter("numeroClient");
		String adresse = request.getParameter("adresseClient");
		
		String montantC = request.getParameter("montantCommande");
		String modePaiement = request.getParameter("modePaiementCommande");
		String modeLivraison = request.getParameter("modeLivraisonCommande");
		String statusPaiement = request.getParameter("statutPaiementCommande");
		String statusLivraison = request.getParameter("statutLivraisonCommande");
		
		double montant;
		String message;
		try {
			montant = Double.parseDouble(request.getParameter("montantCommande"));
		
		} catch (NumberFormatException e )
		{
			montant=-1;
		}
		
		 /* Récupération de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format défini */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd/MM/yyyy HH:mm:ss" );
        String date = dt.toString( formatter );
	    
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || numero.trim().isEmpty() || montantC.trim().isEmpty() || modePaiement.trim().isEmpty() || modeLivraison.trim().isEmpty()) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"Commande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande.";
        } else {
            message = "Commande créée avec succès !";
        }

        
        Clients client = new Clients();
        
        client.setNomClients(nom);
        client.setPrenomClients(request.getParameter("prenomClient"));
        client.setNumeroClients(numero);
        client.setAdresseClients(adresse);
        client.setEmailClients(request.getParameter("emailClient"));
        
        Commandes commande = new Commandes();
        
        commande.setClient(client);
        commande.setDateCommande(date);
        commande.setModePaiementCommande(modePaiement);
        commande.setStatusPaiementCommande(statusPaiement);
        commande.setModeLivraisonCommande(modeLivraison);
        commande.setStatusLivraisonCommande(statusLivraison);
        commande.setMontantCommande(montant);
        
        request.setAttribute("commande", commande);
        request.setAttribute("message", message);
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/afficherCommande.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
