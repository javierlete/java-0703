package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.UsuarioRepository;

import lombok.extern.java.Log;

@Log
@Service
public class UsuarioServiceImpl extends AnonimoServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Video altaVideo(String email, Video video) {
		log.info("ALTA " + video.toString());

		var usuario = usuarioRepository.findByEmail(email);

		if (usuario.getId() != video.getUsuario().getId()) {
			throw new ServiciosException("El video pertenece a un usuario que no es el que ha pedido el cambio");
		}

		return videoRepository.save(video);
	}

	@Override
	public Video modificarVideo(String email, Video video) {
		log.info("MODIFICAR " + video.toString());

		var usuario = usuarioRepository.findByEmail(email);

		if (usuario.getId() != video.getUsuario().getId()) {
			throw new ServiciosException("El video pertenece a un usuario que no es el que ha pedido el cambio");
		}
		
		return videoRepository.save(video);
	}

	@Override
	public void bajaVideo(String email, Long id) {
		var usuario = usuarioRepository.findByEmail(email);
		var videoOptional = videoRepository.findById(id);
		
		if(videoOptional.isEmpty()) {
			throw new ServiciosException("El video no existe");
		}
		
		var video = videoOptional.get();

		if (usuario.getId() != video.getUsuario().getId()) {
			throw new ServiciosException("El video pertenece a un usuario que no es el que ha pedido el cambio");
		}
		
		videoRepository.deleteById(id);
	}

	@Override
	public Comentario altaComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

}
