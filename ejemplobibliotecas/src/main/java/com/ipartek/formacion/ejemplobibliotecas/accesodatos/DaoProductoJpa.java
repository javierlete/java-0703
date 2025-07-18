package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.Optional;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoJpa implements DaoProducto {
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return DaoJpa.obtenerTodos(Producto.class);
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		return DaoJpa.obtenerPorId(Producto.class, id);
	}

	@Override
	public Producto insertar(Producto producto) {
		return DaoJpa.insertar(producto);
	}

	@Override
	public Producto modificar(Producto producto) {
		return DaoJpa.modificar(producto);
	}

	@Override
	public void borrar(Long id) {
		DaoJpa.borrar(Producto.class, id);
	}
}
