package pojos;

import java.time.LocalDate;
import java.util.Objects;

import bibliotecas.Fechas;

public class Persona {
	// CONSTANTES
	private static final String NOMBRE_POR_DEFECTO = "ANÓNIMO";
	protected static final int MAYORIA_DE_EDAD = 18;
	
	// VARIABLES DE INSTANCIA
	protected Long id;
	protected String nombre;
	protected LocalDate fechaNacimiento;

	// CONSTRUCTORES
	public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}

	public Persona(String nombre, LocalDate fechaNacimiento) {
		this(null, nombre, fechaNacimiento);
	}

	public Persona(String nombre) {
		this(null, nombre, null);
	}

	public Persona() {
		this(null, NOMBRE_POR_DEFECTO, null);
	}

	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.id, persona.nombre, persona.fechaNacimiento);
	}

	// GETTERS Y SETTERS
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
		if (nombre == null) {
			throw new PojosException("El nombre no puede valer null");
		}

		if (nombre.isBlank()) {
			throw new PojosException("No se admiten nombres en blanco");
		}

		this.nombre = nombre.trim();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
			throw new PojosException("No se admiten fechas futuras");
		}

		this.fechaNacimiento = fechaNacimiento;
	}

	// MÉTODOS PROPIOS
	public Integer getEdad() {
		return Fechas.obtenerEdad(fechaNacimiento);
	}
	
	public Boolean isMayorDeEdad() {
		if (fechaNacimiento == null) {
			return null;
		}

		return getEdad() >= MAYORIA_DE_EDAD;
	}

	// HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
