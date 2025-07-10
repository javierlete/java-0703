package com.ipartek.formacion.ejemplos.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saludar")
public class Saludar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		
		response.setContentType("text/html");
		response.getWriter().append(String.format("""
				<html>
				<body>
				<h1>Hola %s</h1>
				</body>
				</html>
				""", nombre));
	}
}
