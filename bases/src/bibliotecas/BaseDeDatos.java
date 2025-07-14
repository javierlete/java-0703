package bibliotecas;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BaseDeDatos {
	private String url;
	private String user;
	private String pass;
	
	public BaseDeDatos(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		
		if(url.contains(":sqlite:")) {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				throw new AccesoDatosException("No se ha encontrado el driver de SQLite");
			}
		}
	}

	public <T> Iterable<T> ejecutarSql(String sql, Object... parametros) {
		return ejecutarSql(sql, null, parametros);
	}
	
	public <T> Optional<T> ejecutarSqlUno(String sql, Function<ResultSet, T> mapeador, Object... parametros) {
		var resultado = ejecutarSql(sql, mapeador, parametros);

		if (resultado.iterator().hasNext()) {
			return Optional.of(resultado.iterator().next());
		} else {
			return Optional.empty();
		}
	}
	
	public <T> Iterable<T> ejecutarSql(String sql, Function<ResultSet, T> mapeador, Object... parametros) {
		try (var con = DriverManager.getConnection(url, user, pass); var pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			var i = 1;

			for (var parametro : parametros) {
				pst.setObject(i++, parametro);
			}

			if (!sql.startsWith("SELECT")) {
				pst.executeUpdate();
				
				if(sql.startsWith("INSERT")) {
					var rs = pst.getGeneratedKeys();
					
					rs.next();
					
					return List.of(mapeador.apply(rs));
				}
				
				return null;
			}

			var rs = pst.executeQuery();
			var objetos = new ArrayList<T>();

			while (rs.next()) {
				var objeto = mapeador.apply(rs); 
				
				objetos.add(objeto);
			}

			return objetos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema con la operación DAO. " + url, e);
		}
	}

	public static <T extends Identificable> T mapeadorInsercion(T objeto, ResultSet rs) {
		try {
			objeto.setId(rs.getLong(1));
			
			return objeto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}
}
