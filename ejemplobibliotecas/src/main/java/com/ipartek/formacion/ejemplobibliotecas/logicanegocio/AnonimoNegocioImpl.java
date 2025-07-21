package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import java.util.Optional;

import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

import lombok.extern.java.Log;

@Log
public class AnonimoNegocioImpl implements AnonimoNegocio {
	protected static final DaoProducto DAO_PRODUCTO = (DaoProducto) Fabrica.obtener("dao.producto", Producto.class);
	protected static final DaoUsuario DAO_USUARIO = (DaoUsuario) Fabrica.obtener("dao.usuario", Usuario.class);

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
		log.info("Recibido: " + usuario);

		Optional<Usuario> autenticado = DAO_USUARIO.obtenerPorEmail(usuario.getEmail());

		if (autenticado.isPresent()) {
			log.info("Encontrado por email: " + autenticado);
			Usuario usuarioAutenticado = autenticado.get();

			if (usuarioAutenticado.getPassword().equals(usuario.getPassword())) {
				log.info("Contraseña correcta");
				return Optional.of(usuarioAutenticado);
			} else {
				log.warning("CONTRASEÑA INCORRECTA");
			}
		} else {
			log.warning("EMAIL INCORRECTO");
		}

		return Optional.empty();
	}

}
