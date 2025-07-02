package bibliotecas;

import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);

	public static String leerString(String mensaje) {
		System.out.print(mensaje + ": ");
		return SC.nextLine();
	}

	public static Integer leerInteger(String mensaje) {
		return leerInteger(mensaje, null, null);
	}

	public static Integer leerInteger(String mensaje, Integer minimo) {
		return leerInteger(mensaje, minimo, null);
	}

	public static Integer leerInteger(String mensaje, Integer minimo, Integer maximo) {
		boolean correcto = false;

		Integer valor = null;

		mensaje = String.format("%s (%s%s)", mensaje, minimo == null ? "": " minimo " + minimo + " ", maximo == null ? "" : " máximo " + maximo + " ");
		
		minimo = minimo == null ? Integer.MIN_VALUE : minimo;
		maximo = maximo == null ? Integer.MAX_VALUE : maximo;
		
		do {
			try {
				String texto = leerString(mensaje);

				valor = Integer.parseInt(texto);

				if (valor >= minimo && valor <= maximo) {
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
		return leerDouble(mensaje, null, null);
	}

	public static Double leerDouble(String mensaje, Double minimo) {
		return leerDouble(mensaje, minimo, null);
	}

	public static Double leerDouble(String mensaje, Double minimo, Double maximo) {
		boolean correcto = false;

		Double valor = null;
		
		mensaje = String.format("%s (%s%s)", mensaje, minimo == null ? "": " minimo " + minimo + " ", maximo == null ? "" : " máximo " + maximo + " ");
		
		minimo = minimo == null ? Double.MIN_VALUE : minimo;
		maximo = maximo == null ? Double.MAX_VALUE : maximo;

		do {
			try {
				String texto = leerString(mensaje);

				valor = Double.parseDouble(texto);

				if (valor >= minimo && valor <= maximo) {
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
