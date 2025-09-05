package com.ipartek.formacion.ipartube.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.UsuarioRepository;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

@Service
@Primary
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	protected VideoRepository videoRepository;
	
	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Video> verListadoVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Page<Video> verListadoVideos(Long idUsuario, Pageable pageable) {
		return videoRepository.findByUsuarioId(idUsuario, pageable);
	}
	
	@Override
	public Page<Video> verListadoVideos(Pageable pageable) {
		return videoRepository.findAll(pageable);
	}
	
	@Override
	public Optional<Video> verDetalleVideo(Long id) {
		return videoRepository.findById(id);
	}

	@Override
	public Optional<Usuario> verDetalleUsuario(Long id) {
		return usuarioRepository.findById(id);
	}


}
