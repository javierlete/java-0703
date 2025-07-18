package com.ipartek.formacion.bibliotecas;

import java.util.Optional;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoJpa {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.modelos");
	
	public static <T> Iterable<T> obtenerTodos(Class<T> tipo) {
		return operacionEntityManager(em -> em.createQuery("from Producto", tipo).getResultList());
	}

	public static <T> Optional<T> obtenerPorId(Class<T> tipo, Long id) {
		return operacionEntityManager(em -> Optional.ofNullable(em.find(tipo, id)));
	}

	public static <T> T insertar(T objeto) {
		return operacionEntityManager(em -> {
			em.persist(objeto);
			return objeto;
		});
	}

	public static <T> T modificar(T objeto) {
		return operacionEntityManager(em -> {
			em.merge(objeto);
			return objeto;
		});
	}

	public static <T> void borrar(Class<T> tipo, Long id) {
		operacionEntityManager(em -> {
			em.remove(em.find(tipo, id));
			return null;
		});
	}

	public static <T> T operacionEntityManager(Function<EntityManager, T> funcion) {
		EntityManager em = EMF.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			T resultado = funcion.apply(em);
			
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
