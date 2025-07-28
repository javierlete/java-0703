package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface AdminService extends AnonimoService {
	Producto insertarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
	
	Categoria insertarCategoria(Categoria categoria);
	Categoria modificarCategoria(Categoria categoria);
	void borrarCategoria(Long id);
}
