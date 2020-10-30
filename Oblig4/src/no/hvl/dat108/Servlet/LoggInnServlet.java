package no.hvl.dat108.Servlet;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.LIST_URL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;
import no.hvl.dat108.Passordhjelper;

@WebServlet("/" + LOGIN_URL)
public class LoggInnServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private DeltagerDAO deltagerDAO;
    private Passordhjelper PH;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String loginMessage = "";
        
        if (request.getParameter("requiresLogin") != null) {
        	loginMessage = "Forespørselen din krever pålogging. " 
        			+ "(Du kan ha blitt logget ut automatisk)";
        	
        } else if (request.getParameter("invalidUsername") != null) {
        	loginMessage = "Ugyldig brukernavn eller passord"; 
        }

        request.setAttribute("loginMessage", loginMessage);
        
        request.getRequestDispatcher("WEB-INF/login.jsp")
        		.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String mobil = request.getParameter("mobil");
        String passord = request.getParameter("passord");
        
        try {
			
			Deltager d = deltagerDAO.hentDeltager(Integer.parseInt(mobil));
			
			if (PH.validerMedSalt2(passord, d.getPassord().getSalt(), d.getPassord().getHash())) {
				response.sendRedirect("deltagerliste?login");

			}
			else {
				response.sendRedirect(LOGIN_URL + "?invalidUsername");
			}

		} catch (NullPointerException | NumberFormatException e) {
			response.sendRedirect(LOGIN_URL + "?invalidUsername");
		}
        

    }
}
    
