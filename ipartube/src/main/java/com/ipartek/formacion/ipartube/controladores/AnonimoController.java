package com.ipartek.formacion.ipartube.controladores;

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

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;
import com.ipartek.formacion.ipartube.servicios.UsuarioService;

@Controller
public class AnonimoController {
	private static final int TAMANO_PAGINA = 3;

	@Autowired
	private AnonimoService anonimoService;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public String index(Model modelo, @RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "titulo") String ordenar,
			@RequestParam(defaultValue = "ASC") Direction sentido) {
		var videos = anonimoService.verListadoVideos(PageRequest.of(pagina, TAMANO_PAGINA, Sort.by(sentido, ordenar)));
		modelo.addAttribute("videos", videos);
		return "index";
	}

	@GetMapping("/video")
	public String video(Long id, @RequestParam(defaultValue="1") int numeroComentarios, Model modelo, Principal principal) {
		var video = anonimoService.verDetalleVideo(id).orElse(null);
		var comentarios = anonimoService.verComentariosVideo(id, PageRequest.of(0, numeroComentarios, Sort.by(Direction.DESC, "fechaHora")));
		
		if(principal != null) {
			var usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());
			modelo.addAttribute("usuario", usuario);
		}

		modelo.addAttribute("video", video);
		modelo.addAttribute("comentarios", comentarios);
		
		return "video";
	}
	
	@PostMapping("/comentar")
	public String comentar(Long idVideo, String texto, Principal principal) {
		var video = anonimoService.verDetalleVideo(idVideo).get();
		var usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());
		var comentario = Comentario.builder().texto(texto).usuario(usuario).video(video).build();
		
		usuarioService.altaComentario(comentario);
		
		return "redirect:/video?id=" + idVideo; 
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
