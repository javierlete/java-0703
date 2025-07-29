package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/listado")
	public String listado(Model modelo) {
		modelo.addAttribute("productos", adminService.obtenerListadoProductos());
		return "admin/listado";
	}

	@GetMapping("/formulario")
	public String formulario(Model modelo, Long id) {
		if (id != null) {
			var producto = adminService.obtenerDetalleProducto(id);
			modelo.addAttribute("producto", producto.orElse(null));
		} else {
			modelo.addAttribute("producto", Producto.builder().build());
		}

		modelo.addAttribute("categorias", adminService.obtenerListadoCategorias());
		return "admin/formulario";
	}

	@PostMapping("/formulario")
	public String formularioPost(@Valid Producto producto, BindingResult bindingResult, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("categorias", adminService.obtenerListadoCategorias());
			return "admin/formulario";
		}
		
		if (producto.getId() != null) {
			adminService.modificarProducto(producto);
		} else {
			adminService.insertarProducto(producto);
		}

		return "redirect:/admin/listado";
	}
	
	@GetMapping("/borrar")
	public String borrar(Long id) {
		adminService.borrarProducto(id);
		
		return "redirect:/admin/listado";
	}
}
