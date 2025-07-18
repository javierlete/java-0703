package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class AdminNegocioImpl extends AnonimoNegocioImpl implements AdminNegocio {

	@Override
	public Producto insertarProducto(Producto producto) {
		return DAO_PRODUCTO.insertar(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return DAO_PRODUCTO.modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		DAO_PRODUCTO.borrar(id);
	}

}
