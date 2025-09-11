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
	public Video altaVideo(Video video) {
		log.info("ALTA " + video.toString());
		
		return videoRepository.save(video);
	}

	@Override
	public Video modificarVideo(Video video) {
		log.info("MODIFICAR " + video.toString());
	
		return videoRepository.save(video);
	}

	@Override
	public void bajaVideo(Long id) {
		videoRepository.deleteById(id);
	}

	@Override
	public Comentario altaComentario(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

}
