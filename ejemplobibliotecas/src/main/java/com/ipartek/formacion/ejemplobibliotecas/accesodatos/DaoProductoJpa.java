package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoJpa extends DaoJpa<Producto> implements DaoProducto {

	public DaoProductoJpa() {
		super(Producto.class);
	}

	@Override
	public Iterable<Producto> buscarPorCategoria(Long idCategoria) {
		return operacionEntityManager(em -> em.createQuery("from Producto p where p.categoria.id = ?1", Producto.class)
				.setParameter(1, idCategoria).getResultList());
	}

}
