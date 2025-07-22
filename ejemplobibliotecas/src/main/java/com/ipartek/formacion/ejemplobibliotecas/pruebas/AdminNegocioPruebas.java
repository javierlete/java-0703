package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;
import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplobibliotecas.accesodatos.DaoUsuarioJpa;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocioImpl;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.LogicaNegocioException;

public class AdminNegocioPruebas {

	public static void main(String[] args) {
		DaoUsuario daoUsuario = new DaoUsuarioJpa();
		
		daoUsuario.insertar(Usuario.builder().nombre("Javier").email("javier@email.net").password("javier").build());
		daoUsuario.insertar(Usuario.builder().nombre("Pepe").email("pepe@email.net").password("pepe").build());

		for(var u: daoUsuario.obtenerTodos()) {
			System.out.println(u);
		}
		
		System.out.println(daoUsuario.obtenerPorEmail("javier@email.net"));

		AdminNegocio negocio = new AdminNegocioImpl();

		Usuario usuario = Usuario.builder().email("javier@email.net").password("javier").build();
		Optional<Usuario> autenticado = negocio.autenticar(usuario);
		
		if(autenticado.isPresent()) {
			System.out.println("AUTENTICADO: " + autenticado.get().getNombre());
		} else {
			System.out.println("NO AUTENTICADO");
		}
		
		for (int i = 1; i <= 5; i++) {
			negocio.insertarProducto(Producto.builder().nombre("Producto " + i).precio(new BigDecimal(1000 * i)).build());
		}

		for (var p : negocio.obtenerListadoProductos()) {
			System.out.println(p);
		}

		System.out.println(negocio.obtenerDetalleProducto(3L));
		
		negocio.modificarProducto(Producto.builder().id(2L).nombre("MODIFICADO").precio(new BigDecimal(1234)).build());
		
		negocio.borrarProducto(1L);
		
		for (var p : negocio.obtenerListadoProductos()) {
			System.out.println(p);
		}
		
		try {
			negocio.insertarProducto(Producto.builder().build());
		} catch (LogicaNegocioException ex) {
			for(var e: ex.getErrores()) {
				System.out.println(e.getPropertyPath() + ": " + e.getMessage());
			}
		}
	}

}
