package com.ipartek.formacion.ipartex.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartex.dtos.MensajeDto;
import com.ipartek.formacion.ipartex.entidades.Mensaje;

public interface MensajeRepository extends CrudRepository<Mensaje, Long>, PagingAndSortingRepository<Mensaje, Long>{

	@Query("""
			select new com.ipartek.formacion.ipartex.dtos.MensajeDto(
				m.id, m.usuario.nombre, m.fechaHora, m.texto, count(r.id)) 
			from Mensaje m 
			left join Mensaje r on r.mensajePadre.id = m.id
			where m.mensajePadre.id = :id or (:id is null and m.mensajePadre.id is null)
			group by m.id, m.usuario.nombre, m.fechaHora, m.texto
			""")
	Page<MensajeDto> findByMensajePadreId(Long id, Pageable pageable);

}
