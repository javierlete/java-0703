package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;

public interface UsuarioService extends AnonimoService {
	
	Video altaVideo(Video video);

	Usuario obtenerUsuarioPorEmail(String email);

	Comentario altaComentario(Comentario comentario);

	Video modificarVideo(Video video);

	void bajaVideo(Long id);
}
