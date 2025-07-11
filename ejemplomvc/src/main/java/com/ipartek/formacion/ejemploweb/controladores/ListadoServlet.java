package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.ejemploweb.modelos.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información
//		Crear objetos de modelo
//		Ejecutar lógica de negocio
		var productos = List.of(
				new Producto(1L, "Portátil", new BigDecimal("1234.12")),
				new Producto(2L, "Monitor", new BigDecimal("234.12")),
				new Producto(3L, "Ratón", new BigDecimal("34.12"))
		);

//		Empaquetar modelo para la vista
		request.setAttribute("productos", productos);
		
//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request, response);
	}
}
