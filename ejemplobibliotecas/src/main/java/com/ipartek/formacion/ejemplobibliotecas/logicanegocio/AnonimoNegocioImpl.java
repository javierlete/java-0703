package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuarioJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class AnonimoNegocioImpl implements AnonimoNegocio {
	protected static final DaoProducto DAO_PRODUCTO = new DaoProductoJpa(Producto.class);
	protected static final DaoUsuario DAO_USUARIO = new DaoUsuarioJpa(Usuario.class);

	@Override
	public Iterable<Producto> obtenerListadoProductos() {
		return DAO_PRODUCTO.obtenerTodos();
	}

	@Override
	public Optional<Producto> obtenerDetalleProducto(Long id) {
		return DAO_PRODUCTO.obtenerPorId(id);
	}

	@Override
	public Optional<Usuario> autenticar(Usuario usuario) {
		Optional<Usuario> autenticado = DAO_USUARIO.obtenerPorEmail(usuario.getEmail());

		if (autenticado.isPresent()) {
			Usuario usuarioAutenticado = autenticado.get();

			if (usuarioAutenticado.getPassword().equals(usuario.getPassword())) {
				return Optional.of(usuarioAutenticado);
			}
		}

		return Optional.empty();
	}

}
