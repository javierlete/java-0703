package accesodatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import pojos.Persona;

public class DaoPersonaArrayList implements DaoPersona {
	private static final ArrayList<Persona> personas = new ArrayList<>();

	@Override
	public Iterable<Persona> obtenerTodos() {
		return Collections.unmodifiableCollection(personas);
	}

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		return personas.stream().filter(p -> id == p.getId()).findFirst();
	}

	@Override
	public Persona insertar(Persona persona) {
		Long id = 1L;

		if (personas.size() > 0) {
//			id = personas.stream().max((p1, p2) -> p1.getId().compareTo(p2.getId())).get().getId() + 1L;
			
			id = personas.stream().map(p -> p.getId()).max((id1, id2) -> id1.compareTo(id2)).get() + 1L;
			
//			id = personas.stream().map(p -> p.getId()).reduce(0L, (acumulado, i) -> (i > acumulado) ? i : acumulado) + 1L;
		}
		
		persona.setId(id);
		
		personas.add(persona);
		
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) {
		for(int i = 0; i < personas.size(); i++) {
			if(persona.getId() == personas.get(i).getId()) {
				personas.set(i, persona);
			}
		}
		
		return persona;
	}

	@Override
	public void borrar(Long id) {
		for(int i = 0; i < personas.size(); i++) {
			if(id == personas.get(i).getId()) {
				personas.remove(i);
			}
		}
	}

	@Override
	public Iterable<Persona> buscarPorNombre(String nombre) {
		return personas.stream().filter(p -> p.getNombre().contains(nombre)).toList();
	}

}
