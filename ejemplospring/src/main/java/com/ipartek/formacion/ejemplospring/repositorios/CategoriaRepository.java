package com.ipartek.formacion.ejemplospring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ejemplospring.entidades.Categoria;

@RepositoryRestResource(path = "categorias", collectionResourceRel = "categorias")
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
