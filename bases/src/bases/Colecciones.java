package bases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Colecciones {
	public static void main(String[] args) {
		var al = new ArrayList<String>();

		al.add("Uno");
		al.add("Trees");
		al.add("Patata");
		al.add("Cuatro");
		al.add("Cuatro");

		al.add(1, "Dos");
		al.set(2, "Tres");
		al.remove(3);

		System.out.println(al);

		for (var e : al) {
			System.out.println(e);
		}

		var s = new HashSet<String>();

		s.add("Uno");
		s.add("Dos");
		s.add("Tres");
		s.add("Cuatro");
		s.add("Dos");

		System.out.println(s);

		var dic = new HashMap<String, Integer>();

		dic.put("Uno", 1);
		dic.put("Dos", 2);
		dic.put("Tres", 3);

		System.out.println(dic.get("Dos"));

		System.out.println("CLAVES");

		for (var clave : dic.keySet()) {
			System.out.println(clave);
		}

		System.out.println("VALORES");

		for (var valor : dic.values()) {
			System.out.println(valor);
		}

		System.out.println("PARES");

		for (var par : dic.entrySet()) {
			System.out.println(par.getKey() + ", " + par.getValue());
		}
	}
}
