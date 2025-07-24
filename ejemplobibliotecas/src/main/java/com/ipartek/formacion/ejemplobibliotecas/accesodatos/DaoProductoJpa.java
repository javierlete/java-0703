package com.ipartek.formacion.ejemplobibliotecas.accesodatos;

import com.ipartek.formacion.bibliotecas.DaoJpa;
import com.ipartek.formacion.ejemplobibliotecas.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

public class DaoProductoJpa extends DaoJpa<Producto> implements DaoProducto {

	public DaoProductoJpa() {
		super(Producto.class);
	}

	@Override
	public Iterable<ProductoDTO> buscarPorCategoria(Long idCategoria) {
		return operacionEntityManager(em -> em.createQuery("""
				select 
					new com.ipartek.formacion.ejemplobibliotecas.dtos.ProductoDTO(
						p.id, p.nombre, p.precio
					)  
				from Producto p 
				where p.categoria.id = ?1
				""", ProductoDTO.class)
				.setParameter(1, idCategoria).getResultList());
	}

}
