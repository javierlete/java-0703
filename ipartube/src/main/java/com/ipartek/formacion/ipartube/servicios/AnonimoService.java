package com.ipartek.formacion.ipartube.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;

public interface AnonimoService {
	Iterable<Video> verListadoVideos();
	Page<Video> verListadoVideos(Pageable pageable);
	Page<Video> verListadoVideos(Long idUsuario, Pageable pageable);
	Optional<Video> verDetalleVideo(Long id);
	Optional<Usuario> verDetalleUsuario(Long id);
	Page<Comentario> verComentariosVideo(Long id, Pageable pageable);
}
