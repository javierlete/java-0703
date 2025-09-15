package com.ipartek.formacion.ipartex.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ipartex.servicios.AnonimoService;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping("/")
	public String listado(Model modelo) {
		modelo.addAttribute("pagina", anonimoService.listarMensajes(PageRequest.of(0, 10, Sort.by(Direction.DESC, "fechaHora"))));
		return "index";
	}
}
