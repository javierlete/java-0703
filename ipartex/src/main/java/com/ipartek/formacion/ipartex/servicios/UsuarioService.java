package com.ipartek.formacion.ipartex.servicios;

import java.util.Optional;

import com.ipartek.formacion.ipartex.entidades.Mensaje;
import com.ipartek.formacion.ipartex.entidades.Usuario;

public interface UsuarioService {
	Optional<Usuario> buscarPorEmail(String email);
	Mensaje enviarMensaje(Mensaje mensaje);
	Mensaje responderMensaje(Long idMensajePadre, Mensaje respuesta);
	Mensaje responderMensaje(Mensaje mensajePadre, Mensaje respuesta);
	Iterable<Usuario> listarUsuarios();
}
