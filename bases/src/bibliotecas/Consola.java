package bibliotecas;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Function;

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
		return leerGenerico(mensaje, texto -> Integer.parseInt(texto), minimo, maximo);
	}

	public static Double leerDouble(String mensaje) {
		return leerDouble(mensaje, null, null);
	}

	public static Double leerDouble(String mensaje, Double minimo) {
		return leerDouble(mensaje, minimo, null);
	}

	public static Double leerDouble(String mensaje, Double minimo, Double maximo) {
		return leerGenerico(mensaje, texto -> Double.parseDouble(texto), minimo, maximo);
	}

	public static Byte leerByte(String mensaje, Byte minimo, Byte maximo) {
		return leerGenerico(mensaje, texto -> Byte.parseByte(texto), minimo, maximo);
	}
	
	public static Long leerLong(String mensaje) {
		return leerGenerico(mensaje, texto -> Long.parseLong(texto), null, null);
	}
	
	public static Long leerLong(String mensaje, Long minimo) {
		return leerGenerico(mensaje, texto -> Long.parseLong(texto), minimo, null);
	}
	
	public static Long leerLong(String mensaje, Long minimo, Long maximo) {
		return leerGenerico(mensaje, texto -> Long.parseLong(texto), minimo, maximo);
	}
	
	public static LocalDate leerLocalDate(String mensaje) {
		return leerGenerico(mensaje, texto -> LocalDate.parse(texto), null, null);
	}
	
	public static LocalDate leerLocalDate(String mensaje, LocalDate minimo, LocalDate maximo) {
		return leerGenerico(mensaje, texto -> LocalDate.parse(texto), minimo, maximo);
	}

	public static <T extends Comparable<? super T>> T leerGenerico(String mensaje, Function<String, T> conversor,
			T minimo, T maximo) {
		boolean correcto = false;

		T valor = null;
		
		mensaje = String.format("%s (%s%s)", mensaje, minimo == null ? "" : " minimo " + minimo + " ",
				maximo == null ? "" : " máximo " + maximo + " ");

		do {
			try {
				String texto = leerString(mensaje);

				valor = conversor.apply(texto);

				var min = minimo == null ? valor: minimo;
				var max = maximo == null ? valor: maximo;

				if (valor.compareTo(min) >= 0 && valor.compareTo(max) <= 0) {
					correcto = true;
				} else {
					System.out.println("El valor no está dentro del rango requerido");
				}
			} catch (Exception e) {
				System.out.println("El formato no es correcto");
				// e.printStackTrace();
			}
		} while (!correcto);

		return valor;
	}

//		private interface Conversor<T> {
//			T convertir(String texto);
//		}
//
//		private static class ConversorLocalDate implements Conversor<LocalDate> {
//			@Override
//			public LocalDate convertir(String texto) {
//				return LocalDate.parse(texto);
//			}
//		}
//		
//		public static LocalDate leerLocalDate(String mensaje, LocalDate minimo, LocalDate maximo) {
//			Conversor<LocalDate> conversor = new ConversorLocalDate();
//			return leerGenerico(mensaje, conversor, minimo, maximo);
//		}
//		
//		public static Long leerLong(String mensaje, Long minimo, Long maximo) {
//			return leerGenerico(mensaje, new Conversor<Long>() {
//				@Override
//				public Long convertir(String texto) {
//					return Long.parseLong(texto);
//				}
//			}, minimo, maximo);
//		}
//		

//			public static <T extends Comparable<? super T>> T leerGenerico(String mensaje, Conversor<T> conversor, T minimo, T maximo) {
//				boolean correcto = false;
//		
//				T valor = null;
//		
//				mensaje = String.format("%s (%s%s)", mensaje, minimo == null ? "" : " minimo " + minimo + " ",
//						maximo == null ? "" : " máximo " + maximo + " ");
//		
//		//		minimo = minimo == null ? T.MIN_VALUE : minimo;
//		//		maximo = maximo == null ? T.MAX_VALUE : maximo;
//		
//				do {
//					try {
//						String texto = leerString(mensaje);
//		
//						valor = conversor.convertir(texto);
//		
//						if (valor.compareTo(minimo) >= 0 && valor.compareTo(maximo) <= 0) {
//							correcto = true;
//						} else {
//							System.out.println("El valor no está dentro del rango requerido");
//						}
//					} catch (Exception e) {
//						System.out.println("El formato no es correcto");
//					}
//				} while (!correcto);
//		
//				return valor;
//			}
}
