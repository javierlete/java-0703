package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import static com.ipartek.formacion.bibliotecas.DaoJpa.operacionEntityManager;

import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoJpa implements DaoProducto {
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return operacionEntityManager(em -> em.createQuery("from Producto", Producto.class).getResultList());
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		return operacionEntityManager(em -> Optional.ofNullable(em.find(Producto.class, id)));
	}

	@Override
	public Producto insertar(Producto producto) {
		return operacionEntityManager(em -> {
			em.persist(producto);
			return producto;
		});
	}

	@Override
	public Producto modificar(Producto producto) {
		return operacionEntityManager(em -> {
			em.merge(producto);
			return producto;
		});
	}

	@Override
	public void borrar(Long id) {
		operacionEntityManager(em -> {
			em.remove(em.find(Producto.class, id));
			return null;
		});
	}
}
