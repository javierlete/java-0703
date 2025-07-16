package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;

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
		String sId = request.getParameter("id");

		if (sId != null) {
//		Convertir la información
			Long id = Long.parseLong(sId);

//		Crear objetos de modelo
//		Ejecutar lógica de negocio
			var dao = (DaoProductoSqlite) Fabrica.obtener("ejemplomvc.dao.producto", "ejemplomvc.dao.url");
			var producto = dao.obtenerPorId(id).orElse(null);

//		Empaquetar modelo para la vista
			request.setAttribute("producto", producto);
		}

//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");

//		Convertir la información
//		Crear objetos de modelo
		Producto producto = new Producto(id, nombre, precio);

//		Ejecutar lógica de negocio
		if(producto.hayErrores()) {
			request.setAttribute("producto", producto);
			request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
			return;
		}
		
		var dao = (DaoProductoSqlite) Fabrica.obtener("ejemplomvc.dao.producto", "ejemplomvc.dao.url");

		if (producto.getId() == null) {
			dao.insertar(producto);
		} else {
			dao.modificar(producto);
		}

//		Empaquetar modelo para la vista
//		Saltar a la siguiente vista
		response.sendRedirect("listado");
	}
}
