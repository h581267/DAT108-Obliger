package handleliste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		try {
			if (PU.sjekkPassord(passord,"4S2XMwORX4W7wXQ4gUWYkRog+22liC2DD/NIuhmnm5nW31gVotvDZpiVuLVwMQVtzkcpq7V6YwU=")) {
				response.sendRedirect("handle");
			}
			
		} catch (IllegalArgumentException e) {
			out.print("Feil passord");
			response.sendRedirect("logginn");

		}

	}

}
