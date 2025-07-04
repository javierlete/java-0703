package pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class TrabajadorPorHoras extends Trabajador {
	private BigDecimal sueldoPorHora;
	private Integer numeroHorasMensuales;

	public TrabajadorPorHoras(Long id, String nombre, LocalDate fechaNacimiento, String dni, String nss,
			BigDecimal sueldoPorHora, Integer numeroHorasMensuales) {
		super(id, nombre, fechaNacimiento, dni, nss);
		this.sueldoPorHora = sueldoPorHora;
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	public TrabajadorPorHoras(String nombre, LocalDate fechaNacimiento, String dni, String nss,
			BigDecimal sueldoPorHora, Integer numeroHorasMensuales) {
		this(null, nombre, fechaNacimiento, dni, nss, sueldoPorHora, numeroHorasMensuales);
	}

	public BigDecimal getSueldoPorHora() {
		return sueldoPorHora;
	}

	public void setSueldoPorHora(BigDecimal sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}

	public Integer getNumeroHorasMensuales() {
		return numeroHorasMensuales;
	}

	public void setNumeroHorasMensuales(Integer numeroHorasMensuales) {
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoPorHora.multiply(new BigDecimal(numeroHorasMensuales));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroHorasMensuales, sueldoPorHora);
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
		TrabajadorPorHoras other = (TrabajadorPorHoras) obj;
		return Objects.equals(numeroHorasMensuales, other.numeroHorasMensuales)
				&& Objects.equals(sueldoPorHora, other.sueldoPorHora);
	}

	@Override
	public String toString() {
		return String.format(
				"TrabajadorPorHoras [sueldoPorHora=%s, numeroHorasMensuales=%s, dni=%s, nss=%s, id=%s, nombre=%s, fechaNacimiento=%s]",
				sueldoPorHora, numeroHorasMensuales, dni, nss, id, nombre, fechaNacimiento);
	}

}
