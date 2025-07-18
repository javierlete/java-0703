package com.ipartek.formacion.bibliotecas;

import java.util.Optional;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoJpa<T> {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DaoJpa");
	
	private Class<T> tipo;
	
	public DaoJpa(Class<T> tipo) {
		this.tipo = tipo;
	}
	
	public Iterable<T> obtenerTodos() {
		return operacionEntityManager(em -> em.createQuery("from " + tipo.getSimpleName(), tipo).getResultList());
	}

	public Optional<T> obtenerPorId(Long id) {
		return operacionEntityManager(em -> Optional.ofNullable(em.find(tipo, id)));
	}

	public T insertar(T objeto) {
		return operacionEntityManager(em -> {
			em.persist(objeto);
			return objeto;
		});
	}

	public T modificar(T objeto) {
		return operacionEntityManager(em -> {
			em.merge(objeto);
			return objeto;
		});
	}

	public void borrar(Long id) {
		operacionEntityManager(em -> {
			em.remove(em.find(tipo, id));
			return null;
		});
	}

	public <R> R operacionEntityManager(Function<EntityManager, R> funcion) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			R resultado = funcion.apply(em);
			
			transaction.commit();
			
			return resultado;
		} catch (Exception e) {
			if(transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			
			throw new AccesoDatosException("Error en la transacción", e);
		} finally {
			em.close();
		}
	}
}
