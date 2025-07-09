package accesodatos;

import java.util.Optional;

import bibliotecas.Dao;
import pojos.Rol;

public interface DaoRol extends Dao<Rol> {
	Optional<Rol> buscarPorNombre(String nombre);
}
