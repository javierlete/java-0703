package com.ipartek.formacion.ejemplospring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ejemplospring.entidades.Categoria;
import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminRest {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/productos")
	public Producto insertarProducto(@RequestBody Producto producto) {
		return adminService.insertarProducto(producto);
	}
	
	@PutMapping("/productos/{id}")
	public Producto modificarProducto(@PathVariable Long id, @RequestBody Producto producto) {
		return adminService.modificarProducto(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	public void borrarProducto(@PathVariable Long id) {
		adminService.borrarProducto(id);
	}

	@PostMapping("/categorias")
	public Categoria insertarCategoria(@RequestBody Categoria categoria) {
		return adminService.insertarCategoria(categoria);
	}
	
	@PutMapping("/categorias/{id}")
	public Categoria modificarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		return adminService.modificarCategoria(categoria);
	}
	
	@DeleteMapping("/categorias/{id}")
	public void borrarCategoria(@PathVariable Long id) {
		adminService.borrarCategoria(id);
	}
}
