package com.ipartek.formacion.ejemplobibliotecas.controladores;

import java.util.Map;

import com.ipartek.formacion.bibliotecas.Controlador;

public class SaludoControlador implements Controlador {

	@Override
	public String ejecutar(Map<String, String[]> mapaEntrada, Map<String, Object> mapaSalida) {
//		Recoger información de la petición
		String nombre = mapaEntrada.get("nombre")[0];
		
//	    Convertir la información
//	    Crear objetos de modelo
//	    Ejecutar lógica de negocio
		String saludo = "Hola " + nombre; 		
		
//	    Empaquetar modelo para la vista
		mapaSalida.put("saludo", saludo);
		
//	    Saltar a la siguiente vista
		return "/saludo";
	}

}
