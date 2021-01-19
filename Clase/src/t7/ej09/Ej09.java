package t7.ej09;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ej09")
@MultipartConfig(location = "c:\\upload", maxFileSize = 10485760L)
public class Ej09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<form method=\"post\">");
		response.getWriter().println("Fichero " + "<input type=\"file\" name=\"nombre\" ><br><br>");
		response.getWriter().println("<input type=\"submit\">");
		response.getWriter().println("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
