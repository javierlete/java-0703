package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoPrueba {
	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoJpa();

		dao.insertar(Producto.builder().nombre("Producto1").precio(new BigDecimal("1234")).build());
		dao.insertar(Producto.builder().nombre("Producto2").precio(new BigDecimal("2234")).build());

		System.out.println(dao.insertar(Producto.builder().nombre("Producto3").precio(new BigDecimal("3234")).build()));

		dao.modificar(Producto.builder().id(2L).nombre("Producto2222").precio(new BigDecimal("22")).build());
		
		dao.borrar(1L);
		
		for (Producto p : dao.obtenerTodos()) {
			System.out.println(p);
		}
	}
}
