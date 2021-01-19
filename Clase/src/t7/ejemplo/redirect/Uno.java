package t7.ejemplo.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Uno")
public class Uno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<h2>Uno</h2>");
		//response.sendRedirect("/Clase/Dos");
		//request.getRequestDispatcher("/Dos").forward(request, response);
		String datoPrivado = "Dato calculado por Uno";
		request.setAttribute("datoPrivado", datoPrivado);
		request.getRequestDispatcher("/Dos").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
