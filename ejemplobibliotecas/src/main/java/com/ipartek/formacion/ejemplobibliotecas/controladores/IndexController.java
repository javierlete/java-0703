package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.io.IOException;

import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnonimoNegocio negocio = new AnonimoNegocioImpl();
		
		var productos = negocio.obtenerListadoProductos();
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

}
