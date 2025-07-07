package presentacion.consola;

import static bibliotecas.Consola.leerInteger;
import static bibliotecas.Consola.leerLocalDate;
import static bibliotecas.Consola.leerLong;
import static bibliotecas.Consola.leerString;

import accesodatos.DaoPersona;
import accesodatos.DaoPersonaTreeMap;
import pojos.Persona;

public class MantenimientoPersonas {
	private static final DaoPersona DAO = new DaoPersonaTreeMap();
	
	private static final int SALIR = 0;

	public static void main(String[] args) {
		int opcion;

		do {
			menu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void menu() {
		System.out.println("""
				1. Listado
				2. Buscar por id
				3. Buscar por nombre
				
				4. Insertar
				5. Modificar
				6. Borrar
				
				0. Salir
				""");
	}

	private static int pedirOpcion() {
		System.out.println();
		return leerInteger("Dime la opción");
	}

	private static void procesarOpcion(int opcion) {
		System.out.println();
		
		switch(opcion) {
		case 1 -> listado();
		case 2 -> buscar();
		case 3 -> buscarPorNombre();
		case 4 -> insertar();
		case 5 -> modificar();
		case 6 -> borrar();
		case 0 -> System.out.println("Gracias por usar el programa");
		default -> System.out.println("Opción no reconocida");
		}
		
		System.out.println();
	}

	private static void listado() {
		for(var persona: DAO.obtenerTodos()) {
			System.out.println(persona);
		}
	}

	private static void buscar() {
		var id = leerLong("Dime el id a buscar");
		
		var persona = DAO.obtenerPorId(id);
		
		if(persona.isPresent()) {
			System.out.println(persona.get());
		} else {
			System.out.println("No se ha encontrado");
		}
	}

	private static void buscarPorNombre() {
		var nombre = leerString("Dime el nombre a buscar");
		
		for(var persona: DAO.buscarPorNombre(nombre)) {
			System.out.println(persona);
		}
	}

	private static void insertar() {
		var nombre = leerString("Nombre");
		var fechaNacimiento = leerLocalDate("Fecha de nacimiento");
		
		var persona = new Persona(nombre, fechaNacimiento);
		
		DAO.insertar(persona);
	}

	private static void modificar() {
		var id = leerLong("Id");
		var nombre = leerString("Nombre");
		var fechaNacimiento = leerLocalDate("Fecha de nacimiento");
		
		var persona = new Persona(id, nombre, fechaNacimiento);
		
		DAO.modificar(persona);
	}

	private static void borrar() {
		var id = leerLong("Dime el id a borrar");
		
		DAO.borrar(id);
	}
}
