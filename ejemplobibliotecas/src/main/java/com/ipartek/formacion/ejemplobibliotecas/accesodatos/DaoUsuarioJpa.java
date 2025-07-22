package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.Optional;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class DaoUsuarioJpa extends DaoJpa<Usuario> implements DaoUsuario {

	public DaoUsuarioJpa() {
		super(Usuario.class);
	}

	@Override
	public Optional<Usuario> obtenerPorEmail(String email) {
		return operacionEntityManager(
				em -> Optional.ofNullable(em.createQuery("from Usuario u where u.email = ?1", Usuario.class)
						.setParameter(1, email).getSingleResultOrNull()));
	}

}
