package com.ipartek.formacion.ejemploweb.controladores;

import java.io.IOException;

import com.ipartek.formacion.ejemploweb.accesodatos.DaoProductoSqlite;

import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/listado")
public class ListadoAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Recoger información de la petición
//		Convertir la información
//		Crear objetos de modelo
//		Ejecutar lógica de negocio
		var dao = (DaoProductoSqlite)Fabrica.obtener("ejemplomvc.dao.producto", "ejemplomvc.dao.url");
		var productos = dao.obtenerTodos();

//		Empaquetar modelo para la vista
		request.setAttribute("productos", productos);
		
//		Saltar a la siguiente vista
		request.getRequestDispatcher("/WEB-INF/vistas/listado-admin.jsp").forward(request, response);
	}
}
