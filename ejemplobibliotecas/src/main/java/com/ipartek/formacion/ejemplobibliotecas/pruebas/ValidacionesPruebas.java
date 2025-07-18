package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.math.BigDecimal;
import java.util.Set;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Producto;
import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidacionesPruebas {
	public static void main(String[] args) {
		var producto = Producto.builder().nombre("Prueba").precio(new BigDecimal("1234")).build();

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Producto>> violations = validator.validate(producto);

		for (ConstraintViolation<Producto> violation : violations) {
			System.out.printf("%s: %s\n", violation.getPropertyPath(), violation.getMessage());
		}

		var usuario = Usuario.builder().nombre("Pepe").password("alkjdsfl").email("laksdjf@lkajd.com").build();

		Set<ConstraintViolation<Usuario>> violationsUsuario = validator.validate(usuario);

		for (ConstraintViolation<Usuario> violation : violationsUsuario) {
			System.out.printf("%s: %s\n", violation.getPropertyPath(), violation.getMessage());
		}
	}
}
