package t7.ej08;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.Helpers;


@WebServlet("/Ej08")
public class Ej08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String paises = Helpers.generaSelect("paises", Map.of("España","ES","Italia","IT","Francia","FR","Portugal","PO"), "ES");
		response.getWriter().println("<form method=\"post\">");
		response.getWriter().println("Nombre " + "<input type=\"text\" name=\"nombre\" ><br><br>");
		response.getWriter().println("Clave " + "<input type=\"text\" name=\"clave\" ><br><br>");
		response.getWriter().println("País "+paises +"<br/><br>");
		response.getWriter().println("<input type=\"submit\">");
		response.getWriter().println("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		String pais = request.getParameter("paises");
		String mensaje = "";
		
		if( nombre == "" || nombre == null) {
			mensaje = "Debes introducir un nombre<br/>";
		}
		
		if(clave.length() < 6 || clave.length() > 12 ) {
			mensaje += "Clave debe tener entre 6 y 12 carácteres";
		}
		
		if( pais == "" || pais == null) {
			mensaje += "Debes seleccionar un País.<br /> ";
		}
		
		
		
		response.getWriter().println(mensaje);
		response.getWriter().println("Has introducido: " + nombre + ", " + clave + ", " + pais);
	}

}
