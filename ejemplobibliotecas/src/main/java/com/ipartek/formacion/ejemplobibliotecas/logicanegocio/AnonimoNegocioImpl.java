package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import java.util.Optional;

import org.jboss.logging.Logger;

import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProducto;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuarioJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class AnonimoNegocioImpl implements AnonimoNegocio {
	protected static final DaoProducto DAO_PRODUCTO = new DaoProductoJpa(Producto.class);
	protected static final DaoUsuario DAO_USUARIO = new DaoUsuarioJpa(Usuario.class);

	private static final Logger log = Logger.getLogger(AnonimoNegocioImpl.class.getName());
	
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
				log.warn("CONTRASEÑA INCORRECTA");
			}
		} else {
			log.warn("EMAIL INCORRECTO");
		}

		return Optional.empty();
	}

}
