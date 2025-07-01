package bases;

import java.time.LocalDate;

public class ConversionAString {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		
		String texto = ld.toString(); // La más habitual
		
		System.out.println(texto);

		texto = String.valueOf(ld); // También válida, pero no se usa tan a menudo
		
		System.out.println(texto);
		
		int x = 5;
		
		texto = String.valueOf(x); // Única forma de hacerlo para tipos primitivos
		
		System.out.println(texto);
		
		System.out.println("x vale " + x); // Las concatenaciones con texto, convierten a texto
		
		System.out.println("La fecha de hoy es " + ld);
		
		System.out.println(ld); // El método println está preparado para convertir a texto lo que le pases sin necesidad de conversión explícita
	}
}
