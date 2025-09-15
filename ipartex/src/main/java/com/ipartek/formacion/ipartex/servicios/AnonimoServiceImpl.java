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
		return mensajeRepository.findAll(pageable);
	}
	
}
