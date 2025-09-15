package com.ipartek.formacion.ipartex.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ipartek.formacion.ipartex.servicios.AnonimoService;
import com.ipartek.formacion.ipartex.servicios.UsuarioService;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
		modelo.addAttribute("pagina", anonimoService.listarMensajes(PageRequest.of(0, 10, Sort.by(Direction.DESC, "fechaHora"))));
		return "index";
	}
}
