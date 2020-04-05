package test.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.beans.Auteur;

/**
 * Servlet implementation class Test
 */
@WebServlet(name = "Tests", urlPatterns = { "/Tests" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String paramAuteur = request.getParameter( "nom" ); //Creation d'un paramètre
		//String paramPrenomAuteur = request.getParameter( "prenom" );
		String message = "Transmission de variables : OK ! " ;
		request.setAttribute( "test", message ); //Creation de l'attribut
		
		Auteur auteur = new Auteur(); //Instanciation du bean Auteur
		auteur.setNom("Banga");
		auteur.setPrenom("Roméo");
		auteur.setActif(true);
		request.setAttribute("auteur", auteur);
		
		Auteur auteur2 = new Auteur(); //Instanciation du bean Auteur
		auteur2.setNom("Banga");
		auteur2.setPrenom("Aaron");
		auteur2.setActif(false);
	//	request.setAttribute("auteur2", auteur2);
		
		//request.setAttribute("param1", paramAuteur);
	
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/index.jsp" ).forward( request, response ); //Retourne la page index.jsp
		//getServletContext() : Permet à la servlet de communiquer avec le conteneur de servlet
		//getRequestDispatcher : Permet de recuperer la ressource
		//forward( request, response ) : Permet d'expedier le couple requete/reponse
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	/*	response.setContentType("text/html"); //Modifie l'entete pour signaler au client qu'on envoie une page HTML
		response.setCharacterEncoding( "UTF-8" );//modifie l'encodage pour prendre en compte tous les types de caractères (arabes, asiatiques, français,...)
		PrintWriter out = response.getWriter(); //PrintWriter : objet permettant d'envoyer du texte
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Test Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Ceci est une page générée depuis une servlet.</h1>");
		out.println("<h2>Cela fonctionne bien.</h2>");
		out.println("</body>");
		out.println("</html>");
		
		/*Script pour générer une page HTML via une servlet */
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
