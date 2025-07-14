package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información
//		Crear objetos de modelo
//		Ejecutar lógica de negocio
		request.getSession().invalidate();
		
//		Empaquetar modelo para la vista
//		Saltar a la siguiente vista
		response.sendRedirect("login");
	}
}
