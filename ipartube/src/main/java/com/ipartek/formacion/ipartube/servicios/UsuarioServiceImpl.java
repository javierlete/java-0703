package com.ipartek.formacion.ipartube.servicios;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;

@Service
public class UsuarioServiceImpl extends AnonimoServiceImpl implements UsuarioService {
	@Override
	public Video altaVideo(Video video) {
		return videoRepository.save(video);
	}

}
