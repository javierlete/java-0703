package bibliotecas;

import java.time.LocalDate;
import java.time.Period;

public class Fechas {
	public static Integer obtenerEdad(LocalDate fecha) {
		if (fecha == null) {
			return null;
		}

		return Period.between(fecha, LocalDate.now()).getYears();
	}
}
