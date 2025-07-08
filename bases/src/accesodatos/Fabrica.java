package accesodatos;

import java.io.IOException;
import java.util.Properties;

public class Fabrica {

	private static final String URL;
	private static final String CLASE;
	
	static {
		try {
			Properties props = new Properties();
			props.load(Fabrica.class.getClassLoader().getResourceAsStream("ejemplo.properties"));
			
			URL = props.getProperty("dao.url");
			CLASE = props.getProperty("dao.clase");
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar el fichero de configuración", e);
		}
	}
	
	public static Object obtener() {
		return switch (CLASE) {
		case "daopersonasqlite" -> new DaoPersonaSqlite3(URL);
		case "daopersonatreemap" -> new DaoPersonaTreeMap();
		default -> throw new IllegalArgumentException("No se reconoce la clase " + CLASE);
		};
	}

}
