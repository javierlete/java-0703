package com.ipartek.formacion.ejemploweb.accesodatos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.ipartek.formacion.ejemploweb.modelos.Producto;

import bibliotecas.AccesoDatosException;
import bibliotecas.BaseDeDatos;

public class DaoProductoSqlite implements DaoProducto {
	private final BaseDeDatos bdd;

	public DaoProductoSqlite(String url) {
		bdd = new BaseDeDatos(url, null, null);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return bdd.ejecutarSql("SELECT * FROM productos", rs -> filaAObjeto(rs));
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		return bdd.ejecutarSqlUno("SELECT * FROM productos WHERE id=?", rs -> filaAObjeto(rs), id);
	}

	@Override
	public Producto insertar(Producto producto) {
		return bdd.ejecutarSqlUno("INSERT INTO productos (nombre, precio) VALUES (?,?)",
				rs -> BaseDeDatos.mapeadorInsercion(producto, rs), objetoAFila(producto)).get();
	}

	@Override
	public Producto modificar(Producto producto) {
		bdd.ejecutarSql("UPDATE productos SET nombre=?, precio=? WHERE id=?", objetoAFila(producto));
		return producto;
	}

	@Override
	public void borrar(Long id) {
		bdd.ejecutarSql("DELETE FROM productos WHERE id=?", id);
	}

	private Producto filaAObjeto(ResultSet rs) {
		try {
			var id = rs.getLong("id");
			var nombre = rs.getString("nombre");
			var sPrecio = rs.getString("precio");
			var precio = new BigDecimal(sPrecio);

			return new Producto(id, nombre, precio);
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en el mapeado", e);
		}
	}

	private Object[] objetoAFila(Producto producto) {
		if (producto.getId() != null) {
			return new Object[] { producto.getNombre(), producto.getPrecio(), producto.getId() };
		} else {
			return new Object[] { producto.getNombre(), producto.getPrecio() };
		}
	}
}
