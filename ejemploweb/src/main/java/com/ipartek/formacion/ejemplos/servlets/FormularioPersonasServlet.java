package com.ipartek.formacion.ejemplos.servlets;

import java.io.IOException;
import java.time.LocalDate;

import accesodatos.DaoPersona;
import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojos.Persona;
import pojos.Rol;

@WebServlet("/formulario")
public class FormularioPersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String sFechaNacimiento = request.getParameter("fecha-nacimiento");

		LocalDate fechaNacimiento = LocalDate.parse(sFechaNacimiento);

		var rol = new Rol(2L, null, null);
		
		var persona = new Persona(null, nombre, fechaNacimiento, rol);

		var dao = (DaoPersona) Fabrica.obtener("dao.persona", "dao.url");

		var insertada = dao.insertar(persona);

		response.setContentType("text/html");
		var out = response.getWriter();

		out.append(String.format("""
				<html>
				<body>
				<h1>Personas</h1>

				<p>Persona insertada con el id: %s</p>
				</body>
				</html>
				""", insertada.getId()));
	}
}
