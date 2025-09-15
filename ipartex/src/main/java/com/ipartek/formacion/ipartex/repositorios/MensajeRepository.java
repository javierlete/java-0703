package com.ipartek.formacion.ipartex.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartex.entidades.Mensaje;

public interface MensajeRepository extends CrudRepository<Mensaje, Long>, PagingAndSortingRepository<Mensaje, Long>{

}
