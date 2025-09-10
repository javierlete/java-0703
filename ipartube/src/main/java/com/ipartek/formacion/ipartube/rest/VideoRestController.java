package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartube.dtos.ComentarioDto;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@RestController
@RequestMapping("/api/videos")
public class VideoRestController {
	@Autowired
	private AnonimoService anonimoService;

	@GetMapping
	public Page<Video> get(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "3") int tamanoPagina, @RequestParam(defaultValue = "titulo") String ordenar,
			@RequestParam(defaultValue = "ASC") Direction sentido) {
		return anonimoService.verListadoVideos(PageRequest.of(pagina, tamanoPagina, Sort.by(sentido, ordenar)));
	}

	@GetMapping("{id}")
	public Video getVideo(@PathVariable Long id) {
		return anonimoService.verDetalleVideo(id).orElse(null);
	}

	@GetMapping("{id}/comentarios")
	public Page<ComentarioDto> getComentarios(@PathVariable Long id,
			@PageableDefault(page = 0, size = 3, direction = Direction.DESC, sort = "fechaHora") Pageable pageable) {
		
		return anonimoService.comentariosResumidos(id, pageable);
	}
}
