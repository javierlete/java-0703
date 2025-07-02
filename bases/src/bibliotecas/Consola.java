package bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final Scanner SC= new Scanner(System.in);
	
	public static String leerString(String mensaje) {
		System.out.print(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static Integer leerInteger(String mensaje) {
		return leerInteger(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static Integer leerInteger(String mensaje, int minimo) {
		return leerInteger(mensaje, minimo, Integer.MAX_VALUE);
	}
	
	public static Integer leerInteger(String mensaje, int minimo, int maximo) {
		boolean correcto = false;
		
		Integer valor = null;
		
		do {
			try {
				String texto = leerString(String.format("%s (entre %s y %s)", mensaje, minimo, maximo));

				valor = Integer.parseInt(texto);
				
				if(valor >= minimo && valor <= maximo) {
					correcto = true;
				} else {
					System.out.println("El valor no está dentro del rango requerido");
				}
			} catch (NumberFormatException e) {
				System.out.println("El formato del número no es correcto");
			} 
		} while (!correcto);
		
		return valor;
	}
	
	public static Double leerDouble(String mensaje) {
		return leerDouble(mensaje, Double.MIN_VALUE, Double.MAX_VALUE);
	}

	public static Double leerDouble(String mensaje, double minimo) {
		return leerDouble(mensaje, minimo, Double.MAX_VALUE);
	}
	
	public static Double leerDouble(String mensaje, double minimo, double maximo) {
		boolean correcto = false;
		
		Double valor = null;
		
		do {
			try {
				String texto = leerString(String.format("%s (entre %s y %s)", mensaje, minimo, maximo));

				valor = Double.parseDouble(texto);
				
				if(valor >= minimo && valor <= maximo) {
					correcto = true;
				} else {
					System.out.println("El valor no está dentro del rango requerido");
				}
			} catch (NumberFormatException e) {
				System.out.println("El formato del número no es correcto");
			} 
		} while (!correcto);
		
		return valor;
	}

}
