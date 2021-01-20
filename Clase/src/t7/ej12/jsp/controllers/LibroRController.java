package t7.ej12.jsp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t7.ej12.jsp.model.LibroModel;


@WebServlet("/libro/r")
public class LibroRController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libros",LibroModel.getLibros());
		request.getRequestDispatcher("/views/libro/read.jsp").forward(request, response);
	}


}
