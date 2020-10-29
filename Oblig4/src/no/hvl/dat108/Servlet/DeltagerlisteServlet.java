package no.hvl.dat108.Servlet;

import java.io.IOException;
import java.util.List;
import static no.hvl.dat108.UrlMappings.LOGIN_URL;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;

@WebServlet("/deltagerliste")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("login") != null) {

			List<Deltager> deltagerliste = deltagerDAO.hentAlleDeltagere();

			request.setAttribute("deltagerliste", deltagerliste);

			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(LOGIN_URL);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
