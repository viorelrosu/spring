package t7.ej06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ej06")
public class Ej06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<form method=\"post\">" + 
				"Nombre" + "<input type=\"text\" name=\"nombre\" ><br>"
						+ "<label>Aficiones</label><br />"
						+ "<input type=\"checkbox\" name=\"aficiones[]\" value=\"Bailar\" id=\"bailar\" /><label for=\"bailar\">Bailar</label><br />"
						+ "<input type=\"checkbox\" name=\"aficiones[]\" value=\"Cantar\" id=\"cantar\" /><label for=\"cantar\">Cantar</label><br />"
						+ ""
				+ "<input type=\"submit\"> " + "</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String[] aficiones = request.getParameterValues("aficiones[]");
		String mensaje = "";
		
		if( nombre == "" || nombre == null) {
			mensaje = "Debes introducir un nombre";
		} else {
			if(aficiones == null) {
				mensaje = "A " + nombre + " no le gusta nada.";
			} else {
				mensaje = "A " + nombre + " le gusta: ";
				
				/*
				 * for(int i = 0; i <= aficiones.length; i++) {
				 * response.getWriter().println("<li>"+ aficiones[i] +"</li>"); }
				 */
				
				for(String aficion : aficiones) {
					mensaje += (aficion + " ");
				}
				 
			}
		}
		
		response.getWriter().println(mensaje);
	}

}
