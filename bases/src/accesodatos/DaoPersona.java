package accesodatos;

import bibliotecas.Dao;
import pojos.Persona;

public interface DaoPersona extends Dao<Persona> {
	Iterable<Persona> buscarPorNombre(String nombre);
}
