package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;
import java.util.Optional;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

public class LoginControlador implements ControladorEjemploBibliotecas {

	@Override
	public String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida,
			Map<String, Object> sesionEntrada, Map<String, Object> sesionSalida) {

		if ("GET".equals(metodo)) {
			return "/login";
		}

		String email = mapaEntrada.get("email")[0];
		String password = mapaEntrada.get("password")[0];

		Usuario usuario = Usuario.builder().email(email).password(password).build();

		Optional<Usuario> usuarioAutenticado = ANONIMO_NEGOCIO.autenticar(usuario);

		if (usuarioAutenticado.isEmpty()) {
			return "redirect:/login";
		} else {
			sesionSalida.put("usuario", usuarioAutenticado.get());
			return "redirect:/";
		}
	}

}
