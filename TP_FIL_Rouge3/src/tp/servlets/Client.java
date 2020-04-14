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
 * Servlet implementation class Client
 */
@WebServlet( "/Client" )
public class Client extends HttpServlet {
    private static final long   serialVersionUID = 1L;
    private static final String VUE_FORM         = "/WEB-INF/Client.jsp";
    private static final String VUE_SUCCES       = "/WEB-INF/afficherClient.jsp";
    private static final String ATT_FORM         = "form";
    private static final String ATT_CLIENT       = "client";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Client() {
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

        CreationClient form = new CreationClient();

        Clients client = form.CreerClient( request );

        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() )

            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        else
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

}
