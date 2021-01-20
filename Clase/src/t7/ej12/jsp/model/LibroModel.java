package t7.ej12.jsp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import t7.ej12.jsp.domain.Libro;

public class LibroModel {

	public static List<Libro> getLibros() {
		List<Libro> libros = new ArrayList<>();
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/daw2_servidor_vio","root","root");
			
			PreparedStatement ps = con.prepareStatement("select isbn, titulo, categoria from libros");
			ResultSet rs = ps.executeQuery();
			
			while( rs.next()) {
				String isbn = rs.getString("isbn");
				String titulo = rs.getString("titulo");
				String categoria = rs.getString("categoria");
				
				libros.add(new Libro(isbn, titulo, categoria));
			};
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return libros;
		
	}
}
