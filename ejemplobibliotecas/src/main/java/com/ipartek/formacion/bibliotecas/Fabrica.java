package com.ipartek.formacion.bibliotecas;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Fabrica {
	private static final Map<String, Object> objetos = new HashMap<>();
	
	private static final Properties props = new Properties();

	static {
		try {
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("fabrica.properties"));
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar el fichero de configuración", e);
		}
	}

	public static Object obtener(String propiedadClase, Object... argumentos) {
		var clase = props.getProperty(propiedadClase);

		if(clase == null) {
			throw new IllegalArgumentException("No se ha encontrado la clase " + propiedadClase);
		}
		
		if(objetos.containsKey(clase)) {
			return objetos.get(clase);
		}
		
		try {
			Class<?>[] tipos = Arrays.stream(argumentos).map(Object::getClass).toArray(Class<?>[]::new);
			
			Object objeto = Class.forName(clase).getConstructor(tipos).newInstance(argumentos);
			
			objetos.put(clase, objeto);
			
			return objeto;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new IllegalArgumentException("No se puede instanciar un objeto de la clase " + clase, e);
		}
	}

}
