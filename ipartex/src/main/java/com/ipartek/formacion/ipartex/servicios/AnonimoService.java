package com.ipartek.formacion.ipartex.servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipartek.formacion.ipartex.entidades.Mensaje;

public interface AnonimoService {
	Page<Mensaje> listarMensajes(Pageable pageable);
}
