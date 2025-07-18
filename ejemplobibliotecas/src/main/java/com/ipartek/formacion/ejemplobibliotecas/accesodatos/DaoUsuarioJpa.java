package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class DaoUsuarioJpa extends DaoJpa<Usuario> implements DaoUsuario {

	public DaoUsuarioJpa(Class<Usuario> tipo) {
		super(tipo);
	}

}
