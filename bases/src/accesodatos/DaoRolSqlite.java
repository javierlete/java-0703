package accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import bibliotecas.AccesoDatosException;
import bibliotecas.BaseDeDatos;
import pojos.Rol;

public class DaoRolSqlite implements DaoRol {
	private final BaseDeDatos bdd;

	public DaoRolSqlite(String url) {
		bdd = new BaseDeDatos(url, null, null);
	}

	@Override
	public Iterable<Rol> obtenerTodos() {
		return bdd.ejecutarSql("SELECT * FROM roles", DaoRolSqlite::filaAObjeto);
	}

	@Override
	public Optional<Rol> obtenerPorId(Long id) {
		return bdd.ejecutarSqlUno("SELECT * FROM roles WHERE id=?", DaoRolSqlite::filaAObjeto, id);
	}

	@Override
	public Rol insertar(Rol rol) {
		return bdd.ejecutarSqlUno("INSERT INTO roles (nombre, descripcion) VALUES (?,?)", rs -> mapeadorInsercion(rol, rs), objetoAFila(rol)).get();
	}

	private Rol mapeadorInsercion(Rol rol, ResultSet rs) {
		try {
			rol.setId(rs.getLong(1));
			
			return rol;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}
	
	@Override
	public Rol modificar(Rol rol) {
		bdd.ejecutarSql("UPDATE roles SET nombre=?, descripcion=? WHERE id=?", objetoAFila(rol));
		return rol;
	}

	@Override
	public void borrar(Long id) {
		bdd.ejecutarSql("DELETE FROM roles WHERE id=?", id);
	}

	@Override
	public Optional<Rol> buscarPorNombre(String nombre) {
		return bdd.ejecutarSqlUno("SELECT * FROM roles WHERE nombre=?", DaoRolSqlite::filaAObjeto, nombre);
	}

	private static Rol filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");
			var descripcion = rs.getString("descripcion");

			return new Rol(id, nombre, descripcion);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}

	private static Object[] objetoAFila(Rol rol) {
		if (rol.getId() != null) {
			return new Object[] { rol.getNombre(), rol.getDescripcion(), rol.getId() };
		} else {
			return new Object[] { rol.getNombre(), rol.getDescripcion() };
		}
	}
}
