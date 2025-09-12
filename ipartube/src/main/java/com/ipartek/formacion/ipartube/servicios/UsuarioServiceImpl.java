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

		validarPropietario(email, video);

		return videoRepository.save(video);
	}

	@Override
	public Video modificarVideo(String email, Video video) {
		log.info("MODIFICAR " + video.toString());

		var videoOriginal = obtenerVideoOriginal(video.getId());
		
		validarPropietario(email, videoOriginal);
		
		return videoRepository.save(video);
	}

	@Override
	public void bajaVideo(String email, Long id) {
		var videoOriginal = obtenerVideoOriginal(id);

		validarPropietario(email, videoOriginal);
		
		videoRepository.deleteById(id);
	}

	private Video obtenerVideoOriginal(Long id) {
		var videoOptional = videoRepository.findById(id);
		
		if(videoOptional.isEmpty()) {
			throw new ServiciosException("El video no existe");
		}

		var video = videoOptional.get();
		return video;
	}

	private void validarPropietario(String email, Video video) {
		var usuario = usuarioRepository.findByEmail(email);

		if (usuario.getId() != video.getUsuario().getId()) {
			throw new ServiciosException("El video pertenece a un usuario que no es el que ha pedido el cambio");
		}
	}

	@Override
	public Comentario altaComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

}
