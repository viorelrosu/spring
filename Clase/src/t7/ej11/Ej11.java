package t7.ej11;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ej11")
public class Ej11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
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
		HttpSession sesion = request.getSession(true);
		Map<String, String> usuarios = new HashMap<>();
		usuarios.put("Pepe","1234");
		usuarios.put("Alex","1234");
		
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		
		if( ( usuarios.containsKey(nombre) ) && ( usuarios.get(nombre).equals(clave) ) ) {
			
			if( (sesion.getAttribute(nombre) == null) ){
				
				sesion.setAttribute(nombre, 1);
				response.getWriter().println("Es tu primera visita");
			}
			else {
				Integer nv = (Integer) sesion.getAttribute(nombre);
				sesion.setAttribute(nombre, nv+1);
				response.getWriter().println("Visita número: " + nv);
			}
		} else {
			response.getWriter().println("Los datos no son correctos");
		}
		
		
		
		
		
	}

}
