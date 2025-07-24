package com.ipartek.formacion.ejemplobibliotecas.rest;

import java.util.Optional;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;
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

@Path("/categorias")
public class CategoriaRest {
	private static final AdminNegocio NEGOCIO = (AdminNegocio) Fabrica.obtener("negocio.admin");
	
	@GET
	public Iterable<Categoria> get() {
		return NEGOCIO.obtenerListadoCategorias();
	}
	
	@GET
	@Path("{id}")
	public Categoria get(@PathParam("id") Long id) {
		Optional<Categoria> categoria = NEGOCIO.obtenerDetalleCategoria(id);
		
		return categoria.orElseThrow(() -> new NotFoundException());
	}

	@GET
	@Path("{id}/productos")
	public Iterable<ProductoDTO> getProductos(@PathParam("id") Long id) {
		return NEGOCIO.buscarProductosPorCategoria(id);
	}
	
	@POST
	public Response post(Categoria categoria) {
		return Response.status(Status.CREATED).entity(NEGOCIO.insertarCategoria(categoria)).build();
	}
	
	@PUT
	@Path("{id}")
	public Categoria put(@PathParam("id") Long id, Categoria categoria) {
		if(id != categoria.getId()) {
			throw new BadRequestException();
		}
		
		return NEGOCIO.modificarCategoria(categoria);
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		NEGOCIO.borrarCategoria(id);
	}
	
}
