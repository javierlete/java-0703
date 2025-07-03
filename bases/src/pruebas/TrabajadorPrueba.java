package pruebas;

import java.time.LocalDate;

import pojos.Local;
import pojos.Persona;
import pojos.Trabajador;

public class TrabajadorPrueba {
	public static void main(String[] args) {
		Trabajador t = new Trabajador("Javier", LocalDate.of(2007, 1, 1), "12345678Z", "1234123412341234");

		System.out.println(t);

		t.setNombre("Pepe");

		System.out.println(t);

		Persona p = t; // Casting IMPLÍCITO (generalización)

		// System.out.println(p.getDni()); // getDni() NO existe en la clase Persona

		if (p instanceof Trabajador) {
			Trabajador t2 = (Trabajador) p; // Casting EXPLÍCITO (particularización)

			System.out.println(t2.getDni());
		} else {
			System.out.println("p no es un trabajador");
		}

		Object o = t;

		System.out.println(o.toString());

		if (o instanceof Trabajador t3) {
			// Trabajador t3 = (Trabajador) o;

			System.out.println(t3.getDni());
		} else {
			System.out.println("o no es instancia de Trabajador");
		}

		Local l = new Local("Ejemplo", t);

		l.entrar(t);

		for (Persona visitante : l.getVisitantes()) {
			System.out.println(visitante);
		}

		Persona p2 = new Persona();

		if (p2 instanceof Trabajador) {
			Trabajador t4 = (Trabajador) p2;

			System.out.println(t4.getDni());
		} else {
			System.out.println("p2 no es instancia de Trabajador");
		}
	}
}
