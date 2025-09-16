package com.ipartek.formacion.ipartex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.repositorios.MensajeRepository;

@Service
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	private MensajeRepository mensajeRepository;
	
	@Override
	public Page<Mensaje> listarMensajes(Pageable pageable) {
		return listadoRespuestas(null, pageable);
	}

	@Override
	public Mensaje obtenerMensaje(Long id) {
		return mensajeRepository.findById(id).orElse(null);
	}

	@Override
	public Page<Mensaje> listadoRespuestas(Long id, Pageable pageable) {
		return mensajeRepository.findByMensajePadreId(id, pageable);
	}
	
}
