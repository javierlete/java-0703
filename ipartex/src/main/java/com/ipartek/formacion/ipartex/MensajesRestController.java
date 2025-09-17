package com.ipartek.formacion.ipartex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartex.dtos.MensajeDto;
import com.ipartek.formacion.ipartex.servicios.AnonimoService;

@RestController
@RequestMapping("/api/mensajes")
public class MensajesRestController {
	@Autowired
	private AnonimoService anonimoService;

	@GetMapping
	public Page<MensajeDto> listarMensajes(Pageable pageable) {
		return anonimoService.listarMensajes(pageable);
	}

	@GetMapping("{id}")
	public MensajeDto obtenerMensaje(@PathVariable Long id) {
		return anonimoService.obtenerMensaje(id);
	}

	@GetMapping("{id}/respuestas")
	public Page<MensajeDto> listadoRespuestas(@PathVariable Long id, Pageable pageable) {
		return anonimoService.listadoRespuestas(id, pageable);
	}
	
}
