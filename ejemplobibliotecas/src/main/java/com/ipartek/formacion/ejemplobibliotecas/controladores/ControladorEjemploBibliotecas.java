package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Controlador;
import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;

public interface ControladorEjemploBibliotecas extends Controlador {

	public static final AdminNegocio ADMIN_NEGOCIO = (AdminNegocio) Fabrica.obtener("negocio.admin");
	public static final AnonimoNegocio ANONIMO_NEGOCIO = (AnonimoNegocio) Fabrica.obtener("negocio.anonimo");

	public static final Iterable<Categoria> CATEGORIAS = ANONIMO_NEGOCIO.obtenerListadoCategorias();

	@Override
	default String preEjecutar(String url, String metodo, Map<String, String[]> mapaEntrada,
			Map<String, Object> mapaSalida, Map<String, Object> sesionEntrada, Map<String, Object> sesionSalida) {
		mapaSalida.put("categorias", CATEGORIAS);

		if (!url.startsWith("/admin")) {
			return null;
		}

		var usuario = sesionEntrada.get("usuario");

		if (usuario == null) {
			return "redirect:/login";
		}

		return null;
	}
}
