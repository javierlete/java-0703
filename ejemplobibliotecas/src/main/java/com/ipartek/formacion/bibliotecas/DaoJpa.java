package com.ipartek.formacion.bibliotecas;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoJpa {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.modelos");
	
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
