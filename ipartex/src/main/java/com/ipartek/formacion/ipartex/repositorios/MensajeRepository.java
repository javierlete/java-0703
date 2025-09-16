package com.ipartek.formacion.ipartex.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartex.entidades.Mensaje;

public interface MensajeRepository extends CrudRepository<Mensaje, Long>, PagingAndSortingRepository<Mensaje, Long>{

	Page<Mensaje> findByMensajePadreId(Long id, Pageable pageable);

}
