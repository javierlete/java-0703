package com.ipartek.formacion.ipartube.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/autenticado")
public class AutenticadoController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/alta-video")
	public String altaVideo(Video video, Principal principal) {
		var usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());
		
		video.setUsuario(usuario);
		
		return "formulario-video";
	}
	
	@PostMapping("/alta-video")
	public String altaVideoPost(@Valid Video video, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formulario-video";
		}
		
		usuarioService.altaVideo(video);
		
		return "redirect:/";
	}
}
