package com.ipartek.formacion.ejemplospring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("productos", anonimoService.obtenerListadoProductos());
		return "index";
	}
	
	@GetMapping("/detalle")
	public String detalle(Long id, Model modelo) {
		modelo.addAttribute("producto", anonimoService.obtenerDetalleProducto(id).orElse(null));
		return "detalle";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
