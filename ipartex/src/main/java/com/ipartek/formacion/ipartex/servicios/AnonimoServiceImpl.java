package com.ipartek.formacion.ipartex.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartex.dtos.MensajeDto;
import com.ipartek.formacion.ipartex.repositorios.MensajeRepository;

@Service
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	private MensajeRepository mensajeRepository;
	
	@Override
	public Page<MensajeDto> listarMensajes(Pageable pageable) {
		return listadoRespuestas(null, pageable);
	}

	@Override
	public MensajeDto obtenerMensaje(Long id) {
		return mensajeRepository.obtenerPorId(id).orElse(null);
	}

	@Override
	public Page<MensajeDto> listadoRespuestas(Long id, Pageable pageable) {
		return mensajeRepository.findByMensajePadreId(id, pageable);
	}
	
}
