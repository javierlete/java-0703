package com.ipartek.formacion.ipartex.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipartek.formacion.ipartex.entidades.Mensaje;

public interface AnonimoService {
	Page<Mensaje> listarMensajes(Pageable pageable);

	Mensaje obtenerMensaje(Long id);

	Page<Mensaje> listadoRespuestas(Long id, Pageable pageable);
}
