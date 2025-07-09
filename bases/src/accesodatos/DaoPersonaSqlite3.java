package accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bibliotecas.AccesoDatosException;
import bibliotecas.BaseDeDatos;
import bibliotecas.Fabrica;
import pojos.Persona;
import pojos.Rol;

public class DaoPersonaSqlite3 implements DaoPersona {
	private static final String SQL_SELECT = """
			SELECT p.id p_id, p.nombre p_nombre, p.fecha_nacimiento p_fecha_nacimiento, r.id r_id, r.nombre r_nombre, r.descripcion r_descripcion
			FROM personas p
			JOIN roles r ON p.rol_id = r.id
			""";
	private final BaseDeDatos bdd;

	public DaoPersonaSqlite3(String url) {
		bdd = new BaseDeDatos(url, null, null);
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		return bdd.ejecutarSql(SQL_SELECT, rs -> filaAObjeto(rs));
	}

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		return bdd.ejecutarSqlUno(SQL_SELECT + "WHERE p_id=?", rs -> filaAObjeto(rs), id);
	}

	@Override
	public Persona insertar(Persona persona) {
		return bdd.ejecutarSqlUno("INSERT INTO personas (nombre, fecha_nacimiento, rol_id) VALUES (?,?,?)", rs -> mapeadorInsercion(persona, rs), objetoAFila(persona)).get();
	}

	private Persona mapeadorInsercion(Persona persona, ResultSet rs) {
		try {
			persona.setId(rs.getLong(1));
			
			return persona;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}

	@Override
	public Persona modificar(Persona persona) {
		bdd.ejecutarSql("UPDATE personas SET nombre=?, fecha_nacimiento=?, rol_id=? WHERE id=?", objetoAFila(persona));
		return persona;
	}

	@Override
	public void borrar(Long id) {
		bdd.ejecutarSql("DELETE FROM personas WHERE id=?", id);
	}

	@Override
	public Iterable<Persona> buscarPorNombre(String texto) {
		return bdd.ejecutarSql(SQL_SELECT + "WHERE p_nombre LIKE ?", rs -> filaAObjeto(rs), "%" + texto + "%");
	}

	@Override
	public Iterable<Persona> buscarPorRol(Long idRol) {
		// return bdd.ejecutarSql(SQL_SELECT + "WHERE r_id=?", rs-> filaAObjeto(rs),
		// idRol);
		var daoRol = (DaoRol) Fabrica.obtener("dao.rol", "dao.url");
		
		var rol = daoRol.obtenerPorId(idRol);
		
		if(rol.isEmpty()) {
			return new ArrayList<Persona>();
		}
		
		return bdd.ejecutarSql("SELECT * FROM personas WHERE rol_id=?", rs -> filaAObjetoSimple(rs, rol.get()), idRol);
	}

	private Persona filaAObjetoSimple(ResultSet rs, Rol rol) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");
			var strFechaNacimiento = rs.getString("fecha_nacimiento");
			var fechaNacimiento = LocalDate.parse(strFechaNacimiento);

			return new Persona(id, nombre, fechaNacimiento, rol);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado simple", e);
		}
	}

	private Persona filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("p_id");
			var nombre = rs.getString("p_nombre");
			var strFechaNacimiento = rs.getString("p_fecha_nacimiento");
			var fechaNacimiento = LocalDate.parse(strFechaNacimiento);

			var rolId = rs.getLong("r_id");
			var rolNombre = rs.getString("r_nombre");
			var rolDescripcion = rs.getString("r_descripcion");

			var rol = new Rol(rolId, rolNombre, rolDescripcion);

			return new Persona(id, nombre, fechaNacimiento, rol);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}

	private Object[] objetoAFila(Persona persona) {
		if (persona.getId() != null) {
			return new Object[] { persona.getNombre(), persona.getFechaNacimiento().toString(),
					persona.getRol().getId(), persona.getId() };
		} else {
			return new Object[] { persona.getNombre(), persona.getFechaNacimiento().toString(),
					persona.getRol().getId() };
		}
	}
}
