package tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.beans.Clients;
import tp.form.CreationClient;

/**
 * Servlet implementation class AfficherClient
 */
@WebServlet( "/AfficherClient" )
public class AfficherClient extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String VUE              = "/WEB-INF/afficherClient.jsp";
    private static final String ATT_FORM         = "formClient";
    private static final String ATT_CLIENT       = "client";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherClient() {
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

        CreationClient formClient = new CreationClient();

        Clients client = formClient.CreerClient( request );

        request.setAttribute( ATT_FORM, formClient );
        request.setAttribute( ATT_CLIENT, client );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
