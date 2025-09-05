package com.ipartek.formacion.ipartube.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class AnonimoController {
	private static final int TAMANO_PAGINA = 3;

	@Autowired
	private AnonimoService anonimoService;

	@GetMapping
	public String index(Model modelo, @RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "titulo") String ordenar,
			@RequestParam(defaultValue = "ASC") Direction sentido) {
		var videos = anonimoService.verListadoVideos(PageRequest.of(pagina, TAMANO_PAGINA, Sort.by(sentido, ordenar)));
		modelo.addAttribute("videos", videos);
		return "index";
	}

	@GetMapping("/video")
	public String video(Long id, Model modelo) {
		var video = anonimoService.verDetalleVideo(id).orElse(null);
		modelo.addAttribute("video", video);
		return "video";
	}
	
	@GetMapping("/usuario")
	public String usuario(Long id, Model modelo, @RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "titulo") String ordenar,
			@RequestParam(defaultValue = "ASC") Direction sentido) {
		var usuario = anonimoService.verDetalleUsuario(id).orElse(null);
		var videos = anonimoService.verListadoVideos(id, PageRequest.of(pagina, TAMANO_PAGINA, Sort.by(sentido, ordenar)));
		
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("videos", videos);
		
		return "usuario";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
