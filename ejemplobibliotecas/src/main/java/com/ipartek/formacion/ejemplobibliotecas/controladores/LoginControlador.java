package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;
import java.util.Optional;

import com.ipartek.formacion.bibliotecas.Controlador;
import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;

public class LoginControlador implements Controlador {

	@Override
	public String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida,
			Map<String, Object> sesionEntrada, Map<String, Object> sesionSalida) {

		if ("GET".equals(metodo)) {
			return "/login";
		}

		String email = mapaEntrada.get("email")[0];
		String password = mapaEntrada.get("password")[0];

		Usuario usuario = Usuario.builder().email(email).password(password).build();

		AnonimoNegocio negocio = (AnonimoNegocio) Fabrica.obtener("negocio.anonimo");

		Optional<Usuario> usuarioAutenticado = negocio.autenticar(usuario);

		if (usuarioAutenticado.isEmpty()) {
			return "redirect:/login";
		} else {
			sesionSalida.put("usuario", usuarioAutenticado.get());
			return "redirect:/";
		}
	}

}
