package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;

public class DaoCategoriaJpa extends DaoJpa<Categoria> implements DaoCategoria {

	public DaoCategoriaJpa() {
		super(Categoria.class);
	}

}
