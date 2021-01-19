package t7.ejemplo.bbdd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BaseDatos")
public class BaseDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/daw2_servidor_vio","root","root");
			/*
			 * PreparedStatement ps = con.prepareStatement("" +
			 * "insert into persona(dni,nombre) " + "values (?,?)"); ps.setInt(1, 2);
			 * ps.setString(2, "Ana"); ps.executeUpdate();
			 */
			
			
			
			PreparedStatement ps = con.prepareStatement(""
					+ "select * from persona");
			
			ResultSet rs = ps.executeQuery();
			
			response.getWriter().println("<table><tr><th>DNI</th><th>Nombre</th></tr>");
			
			while( rs.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				
				response.getWriter().println("<tr><td>" + dni + "</td><td>" + nombre + "</td></tr>");
			};
			
			response.getWriter().println("</table>");
			
			con.close();
			response.setContentType("text/html");
			response.getWriter().println("<h3>Todo OK. </h3>");
		}
		catch (Exception e) {
			response.getWriter().println("<h1>Error: "+e.getMessage()+"</h1>");
		}
		
		
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
