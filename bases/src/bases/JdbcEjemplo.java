package bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcEjemplo {
	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/basededatos";
		String url = "jdbc:sqlite:bdd/ejemplo.db";
		String user = "";
		String pass = "";

		try (Connection con = DriverManager.getConnection(url, user, pass)) {
			String nombre = "Otro nuevo";
			String fechaNacimiento = "2003-01-02'); DROP TABLE personas; --";
			
			String sql = "INSERT INTO personas (nombre, fecha_nacimiento) VALUES (?, ?)";
			
			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, nombre);
				pst.setString(2, fechaNacimiento);
				
				int numeroRegistrosModificados = pst.executeUpdate();

				System.out.println(numeroRegistrosModificados);

			}

			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM personas");
					ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					System.out.printf("%5s %-10s %10s\n", rs.getString("id"), rs.getString("nombre"),
							rs.getString("fecha_nacimiento"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
