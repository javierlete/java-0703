package pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import bibliotecas.Fechas;

public abstract class Trabajador extends Persona {
	protected String dni;
	protected String nss;

	public Trabajador(Long id, String nombre, LocalDate fechaNacimiento, String dni, String nss) {
		super(id, nombre, fechaNacimiento);
		this.dni = dni;
		this.nss = nss;
	}

	public Trabajador(String nombre, LocalDate fechaNacimiento, String dni, String nss) {
		this(null, nombre, fechaNacimiento, dni, nss);
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null || Fechas.obtenerEdad(fechaNacimiento) < MAYORIA_DE_EDAD) {
			throw new PojosException("La fecha de nacimiento de un trabajador es obligatoria y debe tener al menos " + MAYORIA_DE_EDAD + " años");
		}
		
		super.setFechaNacimiento(fechaNacimiento);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}
	
	public abstract BigDecimal getSueldoMensual();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dni, nss);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nss, other.nss);
	}

	@Override
	public String toString() {
		return String.format("Trabajador [id=%s, nombre=%s, fechaNacimiento=%s, dni=%s, nss=%s]", id, nombre,
				fechaNacimiento, dni, nss);
	}

}
