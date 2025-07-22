package com.ipartek.formacion.ejemplobibliotecas.controladores.admin;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Controlador;
import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;

public class BorrarControlador implements Controlador {

	@Override
	public String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		AdminNegocio negocio = (AdminNegocio) Fabrica.obtener("negocio.admin");

		String sId = mapaEntrada.get("id")[0];
		Long id = Long.parseLong(sId);

		negocio.borrarProducto(id);

		return "redirect:/admin/listado";
	}

}
