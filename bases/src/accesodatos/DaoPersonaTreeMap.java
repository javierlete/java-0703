package accesodatos;

import java.util.Collections;
import java.util.Optional;
import java.util.TreeMap;

import pojos.Persona;

public class DaoPersonaTreeMap implements DaoPersona {
	private static final TreeMap<Long, Persona> personas = new TreeMap<>();
	
	@Override
	public Iterable<Persona> obtenerTodos() {
		return Collections.unmodifiableCollection(personas.values());
	}

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		return Optional.ofNullable(personas.get(id));
	}

	@Override
	public Persona insertar(Persona persona) {
		Long id = personas.size() > 0 ? personas.lastKey() + 1L: 1L;
		
		persona.setId(id);
		
		personas.put(id, persona);
		
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) {
		personas.put(persona.getId(), persona);
		
		return persona;
	}

	@Override
	public void borrar(Long id) {
		personas.remove(id);
	}

	@Override
	public Iterable<Persona> buscarPorNombre(String nombre) {
		return personas.values().stream().filter(p -> p.getNombre().contains(nombre)).toList();
	}

}
