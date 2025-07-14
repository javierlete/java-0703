package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.ejemploweb.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.ejemploweb.modelos.Usuario;

import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información
//		Crear objetos de modelo
//		Ejecutar lógica de negocio
//		Empaquetar modelo para la vista
//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Convertir la información
//		Crear objetos de modelo
		Usuario usuario = new Usuario(null, null, email, password);
		
//		Ejecutar lógica de negocio
		AnonimoNegocio negocio = (AnonimoNegocio) Fabrica.obtener("ejemplomvc.logicanegocio.anonimo");
		
		Usuario autenticado = negocio.autenticar(usuario);
		
		if(autenticado != null) {
//		Empaquetar modelo para la vista
//		Saltar a la siguiente vista
			session.setAttribute("usuario", autenticado);
			response.sendRedirect("listado");
		} else {
			request.setAttribute("usuario", usuario);
			request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
		
	}
}
