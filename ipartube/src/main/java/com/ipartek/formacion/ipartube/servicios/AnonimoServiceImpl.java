package com.ipartek.formacion.ipartube.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

@Service
@Primary
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	protected VideoRepository videoRepository;
	
	@Override
	public Iterable<Video> verListadoVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Optional<Video> verDetalleVideo(Long id) {
		return videoRepository.findById(id);
	}

}
