package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface UsuarioService extends AnonimoService {
	Video altaVideo(Video video);
}
