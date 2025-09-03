package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@RestController
@RequestMapping("/api/videos")
public class VideoRestController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping
	public Iterable<Video> get() {
		return anonimoService.verListadoVideos();
	}
	
	@GetMapping("{id}")
	public Video getVideo(@PathVariable Long id) {
		return anonimoService.verDetalleVideo(id).orElse(null);
	}
}
