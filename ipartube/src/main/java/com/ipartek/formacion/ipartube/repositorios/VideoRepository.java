package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartube.entidades.Video;

public interface VideoRepository extends CrudRepository<Video, Long>, PagingAndSortingRepository<Video, Long> {

	Page<Video> findByUsuarioId(Long idUsuario, Pageable pageable);

}
