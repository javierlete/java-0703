package com.ipartek.formacion.ipartube.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ipartube.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class AnonimoController {
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping
	public String index(Model modelo) {
		var videos = anonimoService.verListadoVideos();
		modelo.addAttribute("videos", videos);
		return "index";
	}
	
	@GetMapping("/video")
	public String video(Long id, Model modelo) {
		var video = anonimoService.verDetalleVideo(id).orElse(null);
		modelo.addAttribute("video", video);
		return "video";
	}
}
