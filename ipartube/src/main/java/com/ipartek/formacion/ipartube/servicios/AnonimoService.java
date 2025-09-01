package com.ipartek.formacion.ipartube.servicios;

import java.util.Optional;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface AnonimoService {
	Iterable<Video> verListadoVideos();
	Optional<Video> verDetalleVideo(Long id);
}
