package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartube.dtos.ComentarioDto;
import com.ipartek.formacion.ipartube.entidades.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>, PagingAndSortingRepository<Comentario, Long> {
	Page<Comentario> findByVideoId(Long idVideo, Pageable pageable);
	
	@Query("select new com.ipartek.formacion.ipartube.dtos.ComentarioDto(c.usuario.nombre, c.fechaHora, c.texto) from Comentario c where c.video.id = :idVideo")
	Page<ComentarioDto> comentariosResumidos(Long idVideo, Pageable pageable);
}
