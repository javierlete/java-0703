package com.ipartek.formacion.ejemplobibliotecas.modelos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
	private Long id;
	
	@NotBlank
	@Size(max = 50)
	private String nombre;

	@NotNull
	@PositiveOrZero
	private BigDecimal precio;
}
