package com.ipartek.formacion.ipartex.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.servicios.AnonimoService;
import com.ipartek.formacion.ipartex.servicios.UsuarioService;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model modelo, @RequestParam(defaultValue = "2") int numeroMensajes) {
		modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
		modelo.addAttribute("pagina", anonimoService.listarMensajes(PageRequest.of(0, numeroMensajes, Sort.by(Direction.DESC, "fechaHora"))));
		return "index";
	}
	
	@PostMapping("/mensajes")
	public String mensajePost(Mensaje mensaje, Principal principal) {
		var usuario = usuarioService.buscarPorEmail(principal.getName()).orElse(null);
		mensaje.setUsuario(usuario);
		usuarioService.enviarMensaje(mensaje);
		
		return "redirect:/";
	}
	
	@GetMapping("/mensaje")
	public String mensaje(Long id, Model modelo) {
		modelo.addAttribute("mensaje", anonimoService.obtenerMensaje(id));
		modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
		modelo.addAttribute("pagina", anonimoService.listadoRespuestas(id, PageRequest.of(0, 10, Sort.by(Direction.DESC, "fechaHora"))));
		
		return "mensaje";
	}
	
	@PostMapping("/responder")
	public String respuestaPost(Long idMensajePadre, Mensaje mensaje, Principal principal) {
		var usuario = usuarioService.buscarPorEmail(principal.getName()).orElse(null);
		mensaje.setUsuario(usuario);
		usuarioService.responderMensaje(idMensajePadre, mensaje);
		
		return "redirect:/mensaje?id=" + idMensajePadre;
	}
}
