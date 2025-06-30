package bases;

public class Textos {
	public static void main(String[] args) {
		String nombre = "      Javier         ";
		
		System.out.println(nombre);
		
		System.out.println(nombre.trim().toUpperCase());
		
		String texto = "   ";
		
		System.out.println(texto.isBlank());
		
		System.out.println(texto.isEmpty());
		
		texto = "Prueba de texto";
		
		System.out.println(texto.replace("de", "de un"));
		
		String s1 = "Texto";
		String s2 = "Texto";
		
		System.out.println(s1 == s2); // Comparación de punteros (referencias)
		System.out.println(s1.equals(s2)); // Comparación de contenido
	}
}
