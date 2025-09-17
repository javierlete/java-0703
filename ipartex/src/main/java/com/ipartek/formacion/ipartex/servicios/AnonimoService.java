package com.ipartek.formacion.ipartex.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipartek.formacion.ipartex.dtos.MensajeDto;

public interface AnonimoService {
	Page<MensajeDto> listarMensajes(Pageable pageable);

	MensajeDto obtenerMensaje(Long id);

	Page<MensajeDto> listadoRespuestas(Long id, Pageable pageable);
}
