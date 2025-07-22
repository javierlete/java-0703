package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuarioJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class DaoUsuarioPrueba {
	public static void main(String[] args) {
		DaoUsuario dao = new DaoUsuarioJpa();

		dao.insertar(Usuario.builder().nombre("Usuario1").email("a@b.c").password("asdf").build());
		dao.insertar(Usuario.builder().nombre("Usuario2").email("b@b.c").password("2asdf").build());

		System.out.println(dao.insertar(Usuario.builder().nombre("Usuario3").email("c@b.c").password("3asdf").build()));

		dao.modificar(Usuario.builder().id(2L).nombre("MODIFICADO").email("b@b.c").password("2asdf").build());

		dao.borrar(1L);

		for (Usuario u : dao.obtenerTodos()) {
			System.out.println(u);
		}
	}
}
