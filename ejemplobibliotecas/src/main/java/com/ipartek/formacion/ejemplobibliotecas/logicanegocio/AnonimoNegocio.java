package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public interface AnonimoNegocio {
	Iterable<Producto> obtenerListadoProductos();
	Optional<Producto> obtenerDetalleProducto(Long id);
	Iterable<ProductoDTO> buscarProductosPorCategoria(Long idCategoria);
	
	Iterable<Categoria> obtenerListadoCategorias();
	Optional<Categoria> obtenerDetalleCategoria(Long id);

	Optional<Usuario> autenticar(Usuario usuario);
}
