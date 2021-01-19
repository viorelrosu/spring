package t7.ej12;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ej12")
public class Ej12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<h2>Nuevo libro</h2>");
		response.getWriter().println("<form method=\"post\">");
		response.getWriter().println("ISBN " + "<input type=\"text\" name=\"isbn\" ><br><br>");
		response.getWriter().println("Título " + "<input type=\"text\" name=\"titulo\" ><br><br>");
		response.getWriter().println("Categoría " + "<input type=\"text\" name=\"categoria\" ><br><br>");
		response.getWriter().println("<input type=\"submit\">");
		response.getWriter().println("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		String mensaje = "";
		
		if( isbn == "" || isbn == null) {
			mensaje = "Debes introducir un ISBN<br/>";
		} else {
			if( titulo == "" || titulo == null) {
				mensaje = "Debes introducir un titulo<br/>";
			} else {
				if( categoria == "" || categoria == null) {
					mensaje = "Debes introducir una Categoría<br/>";
				} else {
					//insertamos en base de datos
					
					Connection con = null;
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost/daw2_servidor_vio","root","root");
						
						  PreparedStatement ps = con.prepareStatement("" +
						  "insert into libros(isbn,titulo,categoria) " + "values (?,?,?)");
						  ps.setString(1, isbn);
						  ps.setString(2, titulo);
						  ps.setString(3, categoria);
						  ps.executeUpdate();
						
						response.sendRedirect("/Clase/Ej12Libros");
					}
					catch (Exception e) {
						response.getWriter().println("<h1>Error: "+e.getMessage()+"</h1>");
					}
				}
			}
		}
		
	}

}
