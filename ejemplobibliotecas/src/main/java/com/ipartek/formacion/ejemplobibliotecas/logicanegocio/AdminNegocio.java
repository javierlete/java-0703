package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public interface AdminNegocio extends AnonimoNegocio {
	Producto insertarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
	
	Object insertarCategoria(Categoria categoria);
	Categoria modificarCategoria(Categoria categoria);
	void borrarCategoria(Long id);
}
