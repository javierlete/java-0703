package com.ipartek.formacion.ejemploweb.logicanegocio;

import com.ipartek.formacion.ejemploweb.modelos.Usuario;

public class AnonimoNegocioHardCoded implements AnonimoNegocio {

	@Override
	public Usuario autenticar(Usuario usuario) {
		if("javier@email.net".equals(usuario.getEmail()) && "javier".equals(usuario.getPassword()) ) {
			return new Usuario(1L, "Javier", "javier@email.net", "javier");
		}
		
		return null;
	}

}
