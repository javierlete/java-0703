package pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Local {
	private Long id;
	private String nombre;

	private Persona responsable;

	private ArrayList<Persona> visitantes = new ArrayList<Persona>();

	public Local(Long id, String nombre, Persona responsable) {
		setId(id);
		setNombre(nombre);
		setResponsable(responsable);
	}

	public Local(String nombre, Persona responsable) {
		this(null, nombre, responsable);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		if (responsable == null) {
			throw new PojosException("Es obligatorio dar un responsable");
		}

		Boolean mayorDeEdad = responsable.isMayorDeEdad();

		if (mayorDeEdad == null) {
			throw new PojosException("El responsable debe tener fecha de nacimiento");
		}

		if (!mayorDeEdad) {
			throw new PojosException("Debe ser mayor de edad");
		}

		this.responsable = responsable;
	}

	public Collection<Persona> getVisitantes() {
		return Collections.unmodifiableCollection(visitantes);
//		var al = new ArrayList<Persona>();
//		
//		for(var visitante: visitantes) {
//			al.add(new Persona(visitante));
//		}
//		
//		return al;
	}

	public void entrar(Persona visitante) {
		if (visitante == null) {
			throw new PojosException("Es obligatorio proporcionar una persona");
		}

		visitantes.add(visitante);
	}

	public void salir(Persona visitante) {
		visitantes.remove(visitante);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, responsable);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(responsable, other.responsable);
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + "]";
	}

}
