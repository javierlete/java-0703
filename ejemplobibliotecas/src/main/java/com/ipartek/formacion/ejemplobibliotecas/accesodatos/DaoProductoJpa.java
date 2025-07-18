package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import java.util.List;
import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoProductoJpa implements DaoProducto {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.modelos");
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		List<Producto> productos = em.createQuery("from Producto", Producto.class).getResultList();
		
		transaction.commit();
		
		em.close();
		
		return productos;
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		Producto producto = em.find(Producto.class, id);
		
		transaction.commit();
		
		em.close();
		
		return Optional.ofNullable(producto);
	}

	@Override
	public Producto insertar(Producto producto) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.persist(producto);
		
		transaction.commit();
		
		em.close();
		
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.merge(producto);
		
		transaction.commit();
		
		em.close();
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		em.remove(em.find(Producto.class, id));
		
		transaction.commit();
		
		em.close();
	}

}
