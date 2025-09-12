package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;

public interface UsuarioService extends AnonimoService {
	
	Usuario obtenerUsuarioPorEmail(String email);

	Comentario altaComentario(Comentario comentario);

	Video altaVideo(String email, Video video);

	Video modificarVideo(String email, Video video);

	void bajaVideo(String email, Long id);
}
