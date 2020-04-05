package test.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.beans.Auteur;

/**
 * Servlet implementation class page2_servlet
 */
@WebServlet("/page2_servlet")
public class page2_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page2_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String test = "Ceci est un attribut à recuperer par une EL";
		request.setAttribute("test", test);
		
		Auteur auteur = new Auteur(); //Instanciation du bean Auteur
		auteur.setNom("Banga");
		auteur.setPrenom("Roméo");
		auteur.setActif(true);
		request.setAttribute("auteur", auteur);
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/page2.jsp" ).forward( request, response ); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
