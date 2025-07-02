package pruebas;

import java.time.LocalDate;

import pojos.Local;
import pojos.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		Local local = new Local("Online", new Persona("Javier", LocalDate.of(2007, 7, 2)));
		
		local.entrar(new Persona("Pepe"));
		local.entrar(new Persona("Juan"));
		local.entrar(new Persona("Pedro"));
		
		// local.getVisitantes().add(null);
		
		// local.getVisitantes().get(1).setNombre("CAMBIADO");
		
		local.getVisitantes().iterator().next().setNombre("CAMBIADO");
		
		System.out.println(local);
		
		for(Persona visitante: local.getVisitantes()) {
			System.out.println(visitante);
		}
	}
}
