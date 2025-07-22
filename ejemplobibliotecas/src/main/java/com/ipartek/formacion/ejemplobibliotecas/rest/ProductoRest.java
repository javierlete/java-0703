package com.ipartek.formacion.ejemplobibliotecas.rest;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/productos")
public class ProductoRest {
	private static final AdminNegocio NEGOCIO = (AdminNegocio) Fabrica.obtener("negocio.admin");
	
	@GET
	public Iterable<Producto> get() {
		return NEGOCIO.obtenerListadoProductos();
	}
	
	@GET
	@Path("{id}")
	public Producto get(@PathParam("id") Long id) {
		return NEGOCIO.obtenerDetalleProducto(id).orElse(null);
	}
	
	@POST
	public Producto post(Producto producto) {
		return NEGOCIO.insertarProducto(producto);
	}
	
	@PUT
	@Path("{id}")
	public Producto put(@PathParam("id") Long id, Producto producto) {
		return NEGOCIO.modificarProducto(producto);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		NEGOCIO.borrarProducto(id);
	}
	
}
