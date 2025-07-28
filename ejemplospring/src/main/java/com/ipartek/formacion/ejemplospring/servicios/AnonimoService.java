package com.ipartek.formacion.ejemplospring.servicios;

import java.util.Optional;

import com.ipartek.formacion.ejemplospring.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;

public interface AnonimoService {
	Iterable<Producto> obtenerListadoProductos();
	Optional<Producto> obtenerDetalleProducto(Long id);
	Iterable<ProductoDTO> buscarProductosPorCategoria(Long idCategoria);
	
	Iterable<Categoria> obtenerListadoCategorias();
	Optional<Categoria> obtenerDetalleCategoria(Long id);

	Optional<Usuario> autenticar(Usuario usuario);
}
