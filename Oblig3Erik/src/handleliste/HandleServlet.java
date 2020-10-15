package handleliste;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.*;


@WebServlet(name = "handle", urlPatterns = { "/handle" })
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private HandleListe handleliste = new HandleListe();
	private Cookie cookie;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		

		
        List<String> strings = handleliste.getItems();	
		
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Handlelisten</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Min handleliste </h1>");
        out.println("<form action=\"" + "handle" + "\" method=\"post\">");
        out.println("<p><input type=\"submit\" value=\"Legg til\" /> Legg til vare: <input type=\"text\" name=\"vare\" /></p>");
        out.println("<input type=\"hidden\" id=\"itemid\" name=\"handling\" value=" + "Legg" +">");
        out.println("</form>");
        
        if (strings != null) {
        
        for (String s : strings) {
        	out.println("<form action=\"" + "handle" + "\" method=\"post\">");
        	out.println("<input type=\"submit\" value=\"Slett\" />"); 
        	out.println("<input type=\"hidden\" id=\"itemid\" name=\"handling\" value=" + "Slett" +">");
        	out.println("<input type=\"hidden\" id=\"itemid\" name=\"vare\" value=" + s +">");
        	out.println(s + "</br></br>");
        	out.println("</form>");
        }
        }
        
        out.println("<p>" +  "</p>");
        out.println("</body>");
        out.println("</html>");
		
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if (cookie == null) {  // sjekker om det finnes cookie, legger til om ikke
			cookie = new Cookie("innlogget", "");
			cookie.setMaxAge(3600);  // en time
			response.addCookie(cookie);
		}
		
		String input = request.getParameter("handling");	
		String item = request.getParameter("vare");
		
		request.getSession().setAttribute("handling", input);	
		request.getSession().setAttribute("vare", item);
		
		String handling = (String) request.getSession().getAttribute("handling");
		String escvare = (String) request.getSession().getAttribute("vare");	
		
		String vare = org.apache.commons.text.StringEscapeUtils.escapeHtml4(escvare); // ufarliggjør input
		
		System.out.println(handling + " " +vare);  // skriver til konsoll for testing
		
		if (!vare.equals("")) {  // håndterer nullverdi
		
		if (handling.equals("Legg") && !handleliste.finnes(vare)) {
			handleliste.addItem(vare);
		} else if (handling.equals("Slett")) {
			handleliste.slettItem(vare);
		}

		}
		
		response.sendRedirect("handle");
		
		
		
		
		
	}

}
