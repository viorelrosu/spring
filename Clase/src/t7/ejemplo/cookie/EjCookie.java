package t7.ejemplo.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EjCookie")
public class EjCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Cookie existeCookie(Cookie[] cs, String nombre) {
		Cookie sol = null;
		for( Cookie c : cs ) {
			if(c.getName().equals(nombre)) {
				sol = c;
			};
		}
		return sol;
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] cs = request.getCookies();
		if( (cs == null) ){
			response.addCookie(new Cookie("nv","1"));
			response.getWriter().println("Es tu primera visita");
		}
		else {
			Cookie c = existeCookie(cs, "nv");
			if( c != null) {
				Integer nv = Integer.parseInt(c.getValue());
				response.addCookie(new Cookie("nv", Integer.toString(nv+1)));
				response.getWriter().println("Visita número: " + nv);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
