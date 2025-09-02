package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends AnonimoServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Video altaVideo(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

}
