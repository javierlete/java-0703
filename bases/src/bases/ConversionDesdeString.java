package bases;

import java.time.LocalDate;

public class ConversionDesdeString {
	public static void main(String[] args) {
		String valor = "5";
		
		int valorInt = Integer.parseInt(valor);
		
		System.out.println(valorInt);
		
		valor = "2025-01-02";
		
		LocalDate valorFecha = LocalDate.parse(valor);
		
		System.out.println(valorFecha.getYear());
	}
}
