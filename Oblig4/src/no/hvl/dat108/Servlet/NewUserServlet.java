package no.hvl.dat108.Servlet;

import static no.hvl.dat108.UrlMappings.*;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;
import no.hvl.dat108.Passord;


@WebServlet("/nybruker")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerDAO deltagerDAO;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String mobilnummerString = request.getParameter("mobil");
		int mobilnummer = Integer.parseInt(mobilnummerString);
		String nyttPassord = request.getParameter("passord");
		String kjonn = request.getParameter("kjonn");
		Passord passord = Passord.lagPassord(nyttPassord);		
		Deltager ny = new Deltager(fornavn,etternavn,mobilnummer, kjonn,passord);	
		
		if(deltagerDAO.hentDeltager(mobilnummer) == null) {
		deltagerDAO.lagreNyDeltager(ny);
		response.sendRedirect(CONFIRM_URL);
		}
		
		
		response.sendRedirect(LOGIN_URL);
	}

}
