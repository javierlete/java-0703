package accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import bibliotecas.AccesoDatosException;
import bibliotecas.BaseDeDatos;
import pojos.Persona;

public class DaoPersonaSqlite3 implements DaoPersona {
	private final BaseDeDatos bdd;

	public DaoPersonaSqlite3(String url) {
		bdd = new BaseDeDatos(url, null, null);
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		return bdd.ejecutarSql("SELECT * FROM personas", rs -> filaAObjeto(rs));
	}

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		return bdd.ejecutarSqlUno("SELECT * FROM personas WHERE id=?", rs -> filaAObjeto(rs), id);
	}

	@Override
	public Persona insertar(Persona persona) {
		bdd.ejecutarSql("INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?,?)", objetoAFila(persona));
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) {
		bdd.ejecutarSql("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?", objetoAFila(persona));
		return persona;
	}

	@Override
	public void borrar(Long id) {
		bdd.ejecutarSql("DELETE FROM personas WHERE id=?", id);
	}

	@Override
	public Iterable<Persona> buscarPorNombre(String texto) {
		return bdd.ejecutarSql("SELECT * FROM personas WHERE nombre LIKE ?", rs -> filaAObjeto(rs), "%" + texto + "%");
	}

	private Persona filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");
			var strFechaNacimiento = rs.getString("fecha_nacimiento");
			var fechaNacimiento = LocalDate.parse(strFechaNacimiento);

			return new Persona(id, nombre, fechaNacimiento);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}

	private Object[] objetoAFila(Persona persona) {
		if (persona.getId() != null) {
			return new Object[] { persona.getNombre(), persona.getFechaNacimiento().toString(), persona.getId() };
		} else {
			return new Object[] { persona.getNombre(), persona.getFechaNacimiento().toString() };
		}
	}
}
