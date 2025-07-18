package com.ipartek.formacion.ejemplobibliotecas.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;

import jakarta.validation.ConstraintViolation;
import lombok.experimental.StandardException;

@StandardException
public class LogicaNegocioException extends RuntimeException {
	private Set<ConstraintViolation<Producto>> errores;
	
	public LogicaNegocioException(String mensaje, Set<ConstraintViolation<Producto>> errores) {
		this(mensaje);
		
		this.setErrores(errores);
	}

	public Set<ConstraintViolation<Producto>> getErrores() {
		return errores;
	}

	public void setErrores(Set<ConstraintViolation<Producto>> errores) {
		this.errores = errores;
	}

	private static final long serialVersionUID = 7282144300366079212L;

}
