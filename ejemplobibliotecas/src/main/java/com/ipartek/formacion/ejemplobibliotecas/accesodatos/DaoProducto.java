package com.ipartek.formacion.ejemplobibliotecas.accesodatos;


import com.ipartek.formacion.bibliotecas.Dao;
import com.ipartek.formacion.ejemplobibliotecas.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public interface DaoProducto extends Dao<Producto> {
	Iterable<ProductoDTO> buscarPorCategoria(Long idCategoria);
}
