package com.ipartek.formacion.ejemplospring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejemplospring.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@RestController
@RequestMapping("/api/anonimo")
public class AnonimoRest {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping("/productos")
	public Iterable<Producto> listadoProductos() {
		return anonimoService.obtenerListadoProductos();
	}
	
	@GetMapping("/productos/{id}")
	public Producto detalleProducto(@PathVariable Long id) {
		return anonimoService.obtenerDetalleProducto(id).orElse(null);
	}
	
	@GetMapping("/categorias/{id}/productos")
	public Iterable<ProductoDTO> productosPorCategoria(@PathVariable Long id) {
		return anonimoService.buscarProductosPorCategoria(id);
	}
	
	@GetMapping("/categorias")
	public Iterable<Categoria> listadoCategorias() {
		return anonimoService.obtenerListadoCategorias();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria detalleCategoria(@PathVariable Long id) {
		return anonimoService.obtenerDetalleCategoria(id).orElse(null);
	}
}
