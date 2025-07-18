package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class ProductoPrueba {
	public static void main(String[] args) {
		var producto1 = Producto.builder().nombre("Portátil").precio(new BigDecimal(1234)).build();
		var producto2 = Producto.builder().nombre("Portátil").precio(new BigDecimal(1234)).build();
		
		System.out.println(producto1.getNombre());
		System.out.println(producto2.getPrecio());

		System.out.println(producto1.hashCode());
		System.out.println(producto2.hashCode());
		
		System.out.println(producto1.equals(producto2));

		var producto3 = new Producto();
//		var producto4 = new Producto(1L, "Ratón", new BigDecimal(12));
		
		System.out.println(producto3);
//		System.out.println(producto4);
	}
}
