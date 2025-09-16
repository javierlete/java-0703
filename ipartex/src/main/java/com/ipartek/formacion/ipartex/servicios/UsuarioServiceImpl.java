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

	@Override
	public Iterable<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Mensaje responderMensaje(Long idMensajePadre, Mensaje respuesta) {
		var mensajePadre = Mensaje.builder().id(idMensajePadre).build();
		
		return responderMensaje(mensajePadre, respuesta);
	}

	@Override
	public Mensaje responderMensaje(Mensaje mensajePadre, Mensaje respuesta) {
		respuesta.setMensajePadre(mensajePadre);
		return enviarMensaje(respuesta);
	}

}
