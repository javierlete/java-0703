package com.ipartek.formacion.bibliotecas;

import java.util.Map;

public interface Controlador {

	default String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida,
			Map<String, Object> sesionEntrada, Map<String, Object> sesionSalida) {
		return ejecutar(metodo, mapaEntrada, mapaSalida);
	}

	default String ejecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		return ejecutar(mapaEntrada, mapaSalida);
	}

	default String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
		return ejecutar(mapaSalida);
	}
	
	default String ejecutar(Map<String, Object> mapaSalida) {
		return ejecutar();
	}
	
	default String ejecutar() {
		throw new RuntimeException("NO IMPLEMENTADO");
	}

	default String preEjecutar(String metodo, Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida,
			Map<String, Object> sesionEntrada, Map<String, Object> sesionSalida) {
		return null;
	}
}
