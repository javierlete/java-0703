package bases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Fechas {
	public static void main(String[] args) {
		var ahora = LocalDateTime.now();

		System.out.println(ahora);

		var inicio = LocalDateTime.of(2025, 6, 30, 8, 15);

		System.out.println(inicio);
		
		var fechaNacimiento = LocalDate.of(2000,  7, 1);
		
		var edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
		
		System.out.println(edad);
		
		var primerMes = LocalDate.of(2025, 1, 31);
		
		var segundoMes = primerMes.plusMonths(1);
		
		System.out.println(primerMes);
		System.out.println(segundoMes);
	}
}
