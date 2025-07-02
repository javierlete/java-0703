package pruebas;

import static bibliotecas.Consola.*;

public class ConsolaPrueba {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Dime tu nombre: ");
//		String nombre = sc.nextLine();
		
		String nombre = leerString("Dime tu nombre");
		
		System.out.println("Hola " + nombre);
		
		Integer i = leerInteger("Dime un número", null, 100);
		
		System.out.println(i);
		
		Double d = leerDouble("Dime un número con decimales", 1.0, 100.0);
		
		System.out.println(d);
		
//		sc.close();
	}
}
