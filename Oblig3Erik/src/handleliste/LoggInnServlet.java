package handleliste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handleliste.PassordUtil;

@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(("<p style=color:red;> Ugydlig passord.</p>"));

		out.println("<form action=\"logginn\" method=\"post\">");
		out.println("<fieldset>");
		out.println("<p>Gi inn passord:</p>");
		out.println("<p><input type=\"password\" name=\"passord\" /></p>");
		out.println("<p><input type=\"submit\" value=\"Logg inn\" /></p>");
		out.println("</fieldset>");
		out.println("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String passord = request.getParameter("passord");
		PassordUtil PU = new PassordUtil();
		PrintWriter out = response.getWriter();
		String kryptertPassord =request.getSession().getServletContext().getInitParameter("passord");
		Boolean bool;
		
		try {
			if (PU.sjekkPassord(passord,kryptertPassord)) {
				bool = true;
				
				HttpSession sesjon = request.getSession(false);
	            if (sesjon != null) {
	                sesjon.invalidate();
	            }
	            sesjon = request.getSession(true);
	            sesjon.setMaxInactiveInterval(60);
	            sesjon.setAttribute("bool", bool);
				
				response.sendRedirect("handle");
			}
			
		} catch (IllegalArgumentException e) {
			out.print("Feil passord");
			response.sendRedirect("logginn");

		}

	}

}
