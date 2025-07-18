package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public interface AnonimoNegocio {
	Iterable<Producto> obtenerListadoProductos();
	Optional<Producto> obtenerDetalleProducto(Long id);
	
	Optional<Usuario> autenticar(Usuario usuario);
}
