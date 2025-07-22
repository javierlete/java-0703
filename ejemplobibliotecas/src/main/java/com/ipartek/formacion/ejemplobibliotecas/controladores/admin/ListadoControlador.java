package com.ipartek.formacion.ejemplobibliotecas.controladores.admin;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Controlador;
import com.ipartek.formacion.bibliotecas.Fabrica;
import com.ipartek.formacion.ejemplobibliotecas.logicanegocio.AdminNegocio;

public class ListadoControlador implements Controlador {

	@Override
	public String ejecutar(Map<String, Object> mapaSalida) {
		AdminNegocio negocio = (AdminNegocio) Fabrica.obtener("negocio.admin");
		
		var productos = negocio.obtenerListadoProductos();
		
		mapaSalida.put("productos", productos);
		
		return "/admin/listado";
	}

}
