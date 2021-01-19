package t7.ej10;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ej10")
public class Ej10 extends HttpServlet {
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
		response.getWriter().println("<form method=\"post\">");
		response.getWriter().println("Nombre " + "<input type=\"text\" name=\"nombre\" ><br><br>");
		response.getWriter().println("Clave " + "<input type=\"text\" name=\"clave\" ><br><br>");
		response.getWriter().println("<input type=\"submit\">");
		response.getWriter().println("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Map<String, String> usuarios = new HashMap<>();
		usuarios.put("Pepe","1234");
		usuarios.put("Alex","1234");
		
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		
		if( ( usuarios.containsKey(nombre) ) && ( usuarios.get(nombre).equals(clave) ) ) {
			Cookie[] cs = request.getCookies();

			Long milisegundos = System.currentTimeMillis();
			if( (cs == null) ){
				
				response.addCookie(new Cookie(nombre,  Long.toString(milisegundos)));
				response.getWriter().println("Es tu primera visita");
			}
			else {
				Cookie c = existeCookie(cs, nombre);
				if( c != null) {
					Long diff = ( milisegundos - Long.parseLong(c.getValue()) );
					Long segundos = (diff/60);
					response.addCookie(new Cookie(nombre,  Long.toString(milisegundos)));
					if( segundos > 60 ) {
						response.getWriter().println("Has acesado hace más de 1 minuto");
					} else {
						response.getWriter().println("Has acesado hace: " + segundos + " segundos");
					}
				} else {
					response.getWriter().println("No se ha podido recuperar tu cookie.");
				}
			}
		} else {
			response.getWriter().println("Los datos no son correctos");
		}
		
		
		
		
		
	}

}
