package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.ejemploweb.accesodatos.DaoProductoSqlite;
import com.ipartek.formacion.ejemploweb.modelos.Producto;

import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información
//		Crear objetos de modelo
//		Ejecutar lógica de negocio
//		Empaquetar modelo para la vista
//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		
//		Convertir la información
		BigDecimal precio = new BigDecimal(sPrecio);
		
//		Crear objetos de modelo
		Producto producto = new Producto(null, nombre, precio);
		
//		Ejecutar lógica de negocio
		var dao = (DaoProductoSqlite)Fabrica.obtener("ejemplomvc.dao.producto", "ejemplomvc.dao.url");
		dao.insertar(producto);
		
//		Empaquetar modelo para la vista
//		Saltar a la siguiente vista
		response.sendRedirect("listado");
	}
}
