package com.ipartek.formacion.ipartube.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.UsuarioService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/autenticado")
public class AutenticadoController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public String listado(Model modelo, Principal principal) {
		var usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());
		var videos = usuarioService.verListadoVideos(usuario.getId(), PageRequest.of(0, 10));

		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("videos", videos);

		return "autenticado/listado";
	}

	@GetMapping("/alta-video")
	public String altaVideo(Video video, Principal principal) {
		var usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());

		video.setUsuario(usuario);

		return "formulario-video";
	}

	@PostMapping("/alta-video")
	public String altaVideoPost(@Valid Video video, BindingResult bindingResult, @RequestParam(defaultValue = "/") String volver) {
		if (bindingResult.hasErrors()) {
			return "formulario-video";
		}

		System.out.println(video);
		
		if (video.getId() == null) {
			usuarioService.altaVideo(video);
		} else {
			usuarioService.modificarVideo(video);
		}

		log.info("REDIRECCION: " + volver);
		
		return "redirect:" + volver;
	}

	@GetMapping("/insertar")
	public String insertarVideoDesdeListado(Video video, Principal principal, Model modelo) {
		var usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());
		
		video.setUsuario(usuario);
		
		modelo.addAttribute("volver", "/autenticado");
		
		return "formulario-video";
	}

	@GetMapping("/editar")
	public String editar(Long id, Model modelo) {
		var video = usuarioService.verDetalleVideo(id);

		modelo.addAttribute("video", video);
		modelo.addAttribute("volver", "/autenticado");

		return "formulario-video";
	}

	@GetMapping("/borrar")
	public String borrar(Long id) {
		usuarioService.bajaVideo(id);

		return "redirect:/autenticado";
	}
}
