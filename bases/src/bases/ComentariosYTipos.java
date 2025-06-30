package bases;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase de ejemplo de comentarios y tipos de datos
 */
public class ComentariosYTipos {

	/**
	 * Método de inicio de cualquier programa Java
	 * @param args Argumentos de consola
	 */
	public static void main(String[] args) {
		/* Código de la aplicación
		 * Va dentro del main
		 * 
		 * Se ejecuta cuando alguien hace 
		 * java ComentariosYTipos
		 */
		
		System.out.println("Hola desde main"); // Mostramos un texto por consola
		
		int x;
		
		x = 5;
		
		System.out.println(x);
		
		int y = 10;
		
		System.out.println(y);
		
		var z = 20;
		
		System.out.println(z);
		
//		z = "lasjdlfkajdsf"; // No funciona porque una vez declarada una variable, tiene un tipo fijo de por vida
		
		double d1 = 0.1;
		double d2 = 0.2;
		
		double suma = d1 + d2;
		
		System.out.println(suma);
		
		BigDecimal bd1 = new BigDecimal("0.1");
		BigDecimal bd2 = new BigDecimal("0.2");
		
		BigDecimal bdSuma = bd1.add(bd2);
		
		System.out.println(bd1);
		System.out.println(bd2);
		System.out.println(bdSuma);
		
		BigDecimal bd3 = new BigDecimal("10.0");
		BigDecimal bd4 = new BigDecimal("3.0");
		
		BigDecimal bdDivision = bd3.divide(bd4, 2, RoundingMode.HALF_UP);
		
		System.out.println(bdDivision);
		
		long l = 2123123123123123L;
		
		System.out.println(l);
	}
}
