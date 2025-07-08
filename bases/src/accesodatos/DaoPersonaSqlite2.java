package accesodatos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bibliotecas.AccesoDatosException;
import pojos.Persona;

public class DaoPersonaSqlite2 implements DaoPersona {
	private String url = "jdbc:sqlite:bdd/ejemplo.db";
	private String user = "";
	private String pass = "";

	@Override
	public Iterable<Persona> obtenerTodos() {
		return ejecutarSql("SELECT * FROM personas");
	}

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		var resultado = ejecutarSql("SELECT * FROM personas WHERE id=?", id);

		if (resultado.iterator().hasNext()) {
			return Optional.of(resultado.iterator().next());
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Persona insertar(Persona persona) {
		ejecutarSql("INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?,?)", persona.getNombre(),
				persona.getFechaNacimiento().toString());
		return persona;
	}

	@Override
	public Persona modificar(Persona persona) {
		ejecutarSql("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?", persona.getNombre(),
				persona.getFechaNacimiento().toString(), persona.getId());
		return persona;
	}

	@Override
	public void borrar(Long id) {
		ejecutarSql("DELETE FROM personas WHERE id=?", id);
	}

	@Override
	public Iterable<Persona> buscarPorNombre(String texto) {
		return ejecutarSql("SELECT * FROM personas WHERE nombre LIKE ?", "%" + texto + "%");
	}

	private Iterable<Persona> ejecutarSql(String sql, Object... parametros) {
		try (var con = DriverManager.getConnection(url, user, pass); var pst = con.prepareStatement(sql);) {

			var i = 1;

			for (var parametro : parametros) {
				pst.setObject(i++, parametro);
			}

			if (!sql.startsWith("SELECT")) {
				pst.executeUpdate();
				return null;
			}

			var rs = pst.executeQuery();
			var personas = new ArrayList<Persona>();

			while (rs.next()) {
				var id = rs.getLong("id");
				var nombre = rs.getString("nombre");
				var strFechaNacimiento = rs.getString("fecha_nacimiento");
				var fechaNacimiento = LocalDate.parse(strFechaNacimiento);

				personas.add(new Persona(id, nombre, fechaNacimiento));
			}

			return personas;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema con la operación DAO", e);
		}
	}

}
