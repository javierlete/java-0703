package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Controlador;
import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AnonimoNegocio;

public class IndexControlador implements Controlador {

	@Override
	public String ejecutar(Map<String, Object> mapaSalida) {
		AnonimoNegocio negocio = (AnonimoNegocio) Fabrica.obtener("negocio.anonimo");

		mapaSalida.put("productos", negocio.obtenerListadoProductos());

		return "/index";
	}

}
