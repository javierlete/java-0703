package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;
import java.util.List;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistenciaPruebas {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.ipartek.formacion.ejemplobibliotecas.modelos");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		var producto = Producto.builder().nombre("Javier").precio(new BigDecimal(1234)).build();
		
		entityManager.persist(producto);
		
		entityManager.merge(Producto.builder().id(2L).nombre("OTRO NOMBRE").precio(BigDecimal.ONE).build());
		
		entityManager.remove(entityManager.find(Producto.class, 3L));
		
		List<Producto> productos = entityManager.createQuery("from Producto", Producto.class).getResultList();
		
		for(Producto p: productos) {
			System.out.println(p);
		}
		
		Producto producto1 = entityManager.find(Producto.class, 1L);
		
		System.out.println(producto1);
		
		transaction.commit();
	}
}
