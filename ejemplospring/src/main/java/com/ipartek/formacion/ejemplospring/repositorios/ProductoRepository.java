package com.ipartek.formacion.ejemplospring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ejemplospring.dtos.ProductoDTO;
import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	Iterable<ProductoDTO> findByCategoriaId(Long idCategoria);
}
