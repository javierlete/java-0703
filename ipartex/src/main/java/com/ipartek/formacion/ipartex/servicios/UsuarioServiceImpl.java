package com.ipartek.formacion.ipartex.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.entidades.Usuario;
import com.ipartek.formacion.ipartex.repositorios.MensajeRepository;
import com.ipartek.formacion.ipartex.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MensajeRepository mensajeRepository;
	
	@Override
	public Optional<Usuario> buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Mensaje enviarMensaje(Mensaje mensaje) {
		return mensajeRepository.save(mensaje);
	}

}
