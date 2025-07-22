package com.ipartek.formacion.bibliotecas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.validation.ConstraintViolation;

public class Errores {
	public static <T> Map<String, String> contraintViolationsAMapa(Set<ConstraintViolation<T>> constraintViolations) {
		var mapa = new HashMap<String, String>();
		
		for(ConstraintViolation<T> constraintViolation: constraintViolations) {
			mapa.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		
		return mapa;
	}
}
