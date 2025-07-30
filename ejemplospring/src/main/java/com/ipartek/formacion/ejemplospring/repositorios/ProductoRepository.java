package com.ipartek.formacion.ejemplospring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ejemplospring.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplospring.entidades.Producto;

@RepositoryRestResource(path = "productos", collectionResourceRel = "productos")
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Iterable<ProductoDTO> findByCategoriaId(Long idCategoria);
}
