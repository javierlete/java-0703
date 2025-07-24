package com.ipartek.formacion.ejemplobibliotecas.controladores.admin;

import java.util.Map;

import com.ipartek.formacion.ejemplobibliotecas.controladores.ControladorEjemploBibliotecas;

public class ListadoControlador implements ControladorEjemploBibliotecas {

	@Override
	public String ejecutar(Map<String, Object> mapaSalida) {
		var productos = ADMIN_NEGOCIO.obtenerListadoProductos();
		
		mapaSalida.put("productos", productos);
		
		return "/admin/listado";
	}

}
