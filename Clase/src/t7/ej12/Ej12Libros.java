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

@WebServlet("/Ej12Libros")
public class Ej12Libros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/daw2_servidor_vio","root","root");
			 
			
			PreparedStatement ps = con.prepareStatement(""
					+ "select * from libros");
			
			ResultSet rs = ps.executeQuery();
			
			response.getWriter().println("<h1>Libros</h1>");
			response.getWriter().println("<table><tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");
			
			while( rs.next()) {
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String categoria = rs.getString("categoria");
				
				response.getWriter().println("<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria + "</td></tr>");
			};
			
			response.getWriter().println("</table>");
			
			con.close();
			response.setContentType("text/html");
			response.getWriter().println("<h3>Todo OK. </h3>");
			response.getWriter().println("<a href=\"/Clase/Ej12\">Nuevo libro</a>");
			
			
		}
		catch (Exception e) {
			response.getWriter().println("<h1>Error: "+e.getMessage()+"</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
