package com.ipartek.formacion.ejemplospring.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ejemplospring.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
