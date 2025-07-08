package bibliotecas;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Fabrica {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("ejemplo.properties"));
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar el fichero de configuración", e);
		}
	}

	public static Object obtener(String propiedadClase, String... propiedadesArgumentos) {
		var clase = props.getProperty(propiedadClase);

		var argumentos = new String[propiedadesArgumentos.length];
		
		for(int i = 0; i < argumentos.length; i++) {
			argumentos[i] = (String)props.getProperty(propiedadesArgumentos[i]);
		}
 
		try {
			if(argumentos.length == 1 && argumentos[0] != null && !argumentos[0].isBlank()) {
				return Class.forName(clase).getConstructor(String.class).newInstance(argumentos[0]);
			} else {
				return Class.forName(clase).getConstructor().newInstance();
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new IllegalArgumentException("No se puede instanciar un objeto de la clase " + clase, e);
		}
	}

}
