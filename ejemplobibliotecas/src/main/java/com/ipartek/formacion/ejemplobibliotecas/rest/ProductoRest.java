package com.ipartek.formacion.ejemplobibliotecas.rest;

import java.util.Optional;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

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
		Optional<Producto> producto = NEGOCIO.obtenerDetalleProducto(id);
		
		return producto.orElseThrow(() -> new NotFoundException());
	}
	
	@POST
	public Response post(Producto producto) {
		return Response.status(Status.CREATED).entity(NEGOCIO.insertarProducto(producto)).build();
	}
	
	@PUT
	@Path("{id}")
	public Producto put(@PathParam("id") Long id, Producto producto) {
		if(id != producto.getId()) {
			throw new BadRequestException();
		}
		
		return NEGOCIO.modificarProducto(producto);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		NEGOCIO.borrarProducto(id);
	}
	
}
