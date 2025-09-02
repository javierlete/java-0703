package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ipartube.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Usuario findByEmail(String email);

}
