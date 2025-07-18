package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.Optional;

import com.ipartek.formacion.bibliotecas.Dao;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario> {

	Optional<Usuario> obtenerPorEmail(String email);

}
