package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartube.dtos.VideoDto;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
	// TODO Sustituir por detección del usuario logueado
	private static final String email = "javier@email.net";

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("{id}/videos")
	public Page<VideoDto> getVideos(@PathVariable Long id) {
		return usuarioService.verListadoVideos(id, PageRequest.of(0, 10));
	}
	
	@PostMapping("{id}/videos")
	public Video post(@RequestBody Video video) {
		return usuarioService.altaVideo(email, video);
	}

	@PutMapping("{id}/videos/{idVideo}")
	public Video put(@PathVariable Long idVideo, @RequestBody Video video) {
		return usuarioService.modificarVideo(email, video);
	}

	@DeleteMapping("{id}/videos/{idVideo}")
	public void delete(@PathVariable Long id, @PathVariable Long idVideo) {
		usuarioService.bajaVideo(email, idVideo);
	}
}
