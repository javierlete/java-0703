package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Collection;
import java.util.Map;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Categoria;

public class CategoriaControlador implements ControladorEjemploBibliotecas {
	@Override
	public String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		String sIdCategoria = mapaEntrada.get("id")[0];
		Long idCategoria = Long.parseLong(sIdCategoria);
		
		Categoria categoria = ((Collection<Categoria>)CATEGORIAS).stream().filter(c -> c.getId() == idCategoria).findFirst().get();
		
		mapaSalida.put("categoria", categoria);
		mapaSalida.put("productos", ANONIMO_NEGOCIO.buscarProductosPorCategoria(idCategoria));

		return "/index";
	}
}
