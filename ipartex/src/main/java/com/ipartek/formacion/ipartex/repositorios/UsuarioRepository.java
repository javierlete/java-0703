package com.ipartek.formacion.ipartex.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.ipartex.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
