package com.ipartek.formacion.ejemplobibliotecas.controladores.admin;

import java.util.Map;

import com.ipartek.formacion.ejemplobibliotecas.controladores.ControladorEjemploBibliotecas;

public class BorrarControlador implements ControladorEjemploBibliotecas {

	@Override
	public String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		String sId = mapaEntrada.get("id")[0];
		Long id = Long.parseLong(sId);

		ADMIN_NEGOCIO.borrarProducto(id);

		return "redirect:/admin/listado";
	}

}
