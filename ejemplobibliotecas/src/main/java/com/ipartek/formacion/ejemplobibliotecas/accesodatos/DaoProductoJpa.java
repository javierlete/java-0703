package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoJpa extends DaoJpa<Producto> implements DaoProducto {

	public DaoProductoJpa() {
		super(Producto.class);
	}
	
}
