package t7.ej07;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.Helpers;

@WebServlet("/Ej07")
public class Ej07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Map<String, String> colores = new HashMap<>();
		colores.put("azul","azul");
		colores.put("rojo","rojo");
		colores.put("amarillo","amarillo");
		colores.put("verde","verde");
		
		String coloresInputs = Helpers.generaCheckbox("colores", Map.of("A","Azul","R","Rojo","V","Verde"), "Azul");
		String coloresSelect = Helpers.generaSelect("colores", colores, "amarillo");
		String coloresRadio = Helpers.generaRadio("colores", colores, "verde");
		
		response.getWriter().println("<form>");
		response.getWriter().println(coloresInputs +"<br/><br>");
		response.getWriter().println(coloresSelect+"<br/><br/>");
		response.getWriter().println(coloresRadio);
		response.getWriter().println("</form>");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
