package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartube.entidades.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>, PagingAndSortingRepository<Comentario, Long> {
	Page<Comentario> findByVideoId(Long idVideo, Pageable pageable);
}
