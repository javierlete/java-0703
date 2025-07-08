package accesodatos;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import bibliotecas.AccesoDatosException;
import pojos.Persona;

public class DaoPersonaSqlite implements DaoPersona {
	private String url = "jdbc:sqlite:bdd/ejemplo.db";
	private String user = "";
	private String pass = "";

	@Override
	public Iterable<Persona> obtenerTodos() {
		try (var con = DriverManager.getConnection(url, user, pass);
				var pst = con.prepareStatement("SELECT * FROM personas");
				var rs = pst.executeQuery()) {
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

	@Override
	public Optional<Persona> obtenerPorId(Long id) {
		try (var con = DriverManager.getConnection(url, user, pass);
				var pst = con.prepareStatement("SELECT * FROM personas WHERE id=?");) {

			pst.setLong(1, id);

			var rs = pst.executeQuery();

			if (rs.next()) {
				var nombre = rs.getString("nombre");
				var strFechaNacimiento = rs.getString("fecha_nacimiento");
				var fechaNacimiento = LocalDate.parse(strFechaNacimiento);

				return Optional.of(new Persona(id, nombre, fechaNacimiento));
			}

			return Optional.empty();
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema con la operación DAO", e);
		}
	}

	@Override
	public Persona insertar(Persona persona) {
		try (var con = DriverManager.getConnection(url, user, pass);
				var pst = con.prepareStatement("INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?,?)");) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getFechaNacimiento().toString());

			pst.executeUpdate();
			
			return persona;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema con la operación DAO", e);
		}
	}

	@Override
	public Persona modificar(Persona persona) {
		try (var con = DriverManager.getConnection(url, user, pass);
				var pst = con.prepareStatement("UPDATE personas SET nombre=?, fecha_nacimiento=? WHERE id=?");) {

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getFechaNacimiento().toString());
			pst.setLong(3, persona.getId());

			pst.executeUpdate();
			
			return persona;
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema con la operación DAO", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (var con = DriverManager.getConnection(url, user, pass);
				var pst = con.prepareStatement("DELETE FROM personas WHERE id=?");) {

			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un problema con la operación DAO", e);
		}
	}

	@Override
	public Iterable<Persona> buscarPorNombre(String texto) {
		try (var con = DriverManager.getConnection(url, user, pass);
				var pst = con.prepareStatement("SELECT * FROM personas WHERE nombre LIKE ?");
				) {
			
			pst.setString(1, "%" + texto + "%");
			
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
