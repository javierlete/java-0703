package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.ejemploweb.accesodatos.DaoProductoSqlite;

import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
		String sId = request.getParameter("id");

//		Convertir la información
		Long id = Long.parseLong(sId);

//		Crear objetos de modelo
//		Ejecutar lógica de negocio
		var dao = (DaoProductoSqlite) Fabrica.obtener("ejemplomvc.dao.producto", "ejemplomvc.dao.url");
		var producto = dao.obtenerPorId(id).orElse(null);

//		Empaquetar modelo para la vista
		request.setAttribute("producto", producto);
		
//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);
	}
}
