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
	default String preEjecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida,
			Map<String, Object> sesionEntrada, Map<String, Object> sesionSalida) {
		mapaSalida.put("categorias", CATEGORIAS);
		
		return null;
	}
}
