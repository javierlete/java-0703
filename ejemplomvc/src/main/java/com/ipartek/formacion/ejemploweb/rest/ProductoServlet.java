package com.ipartek.formacion.ejemploweb.rest;

import java.io.IOException;

import com.google.gson.Gson;
import com.ipartek.formacion.ejemploweb.accesodatos.DaoProductoSqlite;
import com.ipartek.formacion.ejemploweb.modelos.Producto;

import bibliotecas.Fabrica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos/*")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final DaoProductoSqlite DAO = (DaoProductoSqlite) Fabrica.obtener("ejemplomvc.dao.producto",
			"ejemplomvc.dao.url");

	private static final Gson GSON = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Long id = obtenerId(request);

		String json;

		if (id != null) {
			var producto = DAO.obtenerPorId(id);

			if (producto.isPresent()) {
				json = GSON.toJson(producto.get());
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		} else {
			var productos = DAO.obtenerTodos();
			json = GSON.toJson(productos);
		}

		response.getWriter().append(json);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		var jsonReader = request.getReader();
		var productoRecibido = GSON.fromJson(jsonReader, Producto.class);
		var producto = new Producto(productoRecibido);
		
		if(producto.hayErrores()) {
			var json = GSON.toJson(producto);

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append(json);
			return;
		}
		
		var insertado = DAO.insertar(producto);
		var json = GSON.toJson(insertado);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.getWriter().append(json);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Long id = obtenerId(request);
		
		if(id == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		var jsonReader = request.getReader();
		var productoRecibido = GSON.fromJson(jsonReader, Producto.class);
		var producto = new Producto(productoRecibido);
		
		if(producto.hayErrores()) {
			var json = GSON.toJson(producto);

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append(json);
			return;
		}
		
		if(id != producto.getId()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		var modificado = DAO.modificar(producto);
		var json = GSON.toJson(modificado);
		
		response.getWriter().append(json);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Long id = obtenerId(request);
		
		if(id == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		DAO.borrar(id);

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	private Long obtenerId(HttpServletRequest request) {
		String argumentos = request.getPathInfo();

		if (argumentos == null || argumentos.length() <= 1) {
			return null;
		}

		Long id = Long.parseLong(argumentos.substring(1));

		return id;
	}
}
