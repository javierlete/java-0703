package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

public class IndexControlador implements ControladorEjemploBibliotecas {

	@Override
	public String ejecutar(Map<String, Object> mapaSalida) {
		mapaSalida.put("productos", ANONIMO_NEGOCIO.obtenerListadoProductos());

		return "/index";
	}

}
