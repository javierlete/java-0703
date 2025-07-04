package pruebas;

import static bibliotecas.Consola.*;

import java.time.LocalDate;

public class ConsolaPrueba {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Dime tu nombre: ");
//		String nombre = sc.nextLine();
		
//		String nombre = leerString("Dime tu nombre");
//		
//		System.out.println("Hola " + nombre);
//		
//		Integer i = leerInteger("Dime un número", null, 100);
//		
//		System.out.println(i);
//		
//		Double d = leerDouble("Dime un número con decimales", 1.0, 100.0);
//		
//		System.out.println(d);
		
//		sc.close();
		
		Long l = leerLong("Dime un número");
		
		System.out.println(l);
		
		LocalDate fecha = leerLocalDate("Dime una fecha de nacimiento", LocalDate.of(2000,  1, 1), LocalDate.now());
		
		System.out.println(fecha);
		
		Integer entero = leerGenerico("Dime un entero", texto -> Integer.parseInt(texto), 1, 100);
		
		System.out.println(entero);
	}
}
