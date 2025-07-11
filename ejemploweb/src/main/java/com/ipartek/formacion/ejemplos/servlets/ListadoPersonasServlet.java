package com.ipartek.formacion.ejemplos.servlets;

import java.io.IOException;

import accesodatos.DaoPersona;
import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoPersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var dao = (DaoPersona) Fabrica.obtener("dao.persona", "dao.url");

		response.setContentType("text/html");
		var out = response.getWriter();

		out.append("""
				<html>
				<body>
				<h1>Personas</h1>
				<ul>
				""");

		for (var persona : dao.obtenerTodos()) {
			out.append("<li>" + persona.getNombre() + ", " + persona.getRol().getNombre() + "</li>");
		}

		out.append("""
				</ul>
				</body>
				</html>
				""");
	}
}
