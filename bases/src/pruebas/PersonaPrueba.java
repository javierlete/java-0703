package pruebas;

import java.time.LocalDate;

import pojos.Persona;

public class PersonaPrueba {
	public static void main(String[] args) {
		Persona p = new Persona();
		
		p.setId(1L);
		p.setNombre("      Cabrón       ");
		p.setFechaNacimiento(LocalDate.of(2000, 1, 1));
		
		System.out.println(p.getId());
		System.out.println(p.getNombre());
		System.out.println(p.getFechaNacimiento());
		
		Persona p2 = new Persona(2L, "Pepe", LocalDate.of(2001, 1, 2));
		
		System.out.println(p2);
		
		Persona p3 = new Persona(2L, "Pepe", LocalDate.of(2001, 1, 2));
		
		System.out.println(p3);
		
		System.out.println(p2 == p3);
		System.out.println(p2.equals(p3));
		
		var p4 = new Persona("Sin ID", LocalDate.of(2002, 2, 2));
		
		System.out.println(p4);
		
		var p5 = new Persona("Sólo nombre");
		
		System.out.println(p5);
		
		var p6 = new Persona();
		
		System.out.println(p6);
		
		var pCopia = new Persona(p);
		
		System.out.println(p);
		System.out.println(pCopia);
		
		pCopia.setNombre("Cambiado");

		System.out.println(p);
		System.out.println(pCopia);
		
		System.out.println(p.getEdad());
	}
}
