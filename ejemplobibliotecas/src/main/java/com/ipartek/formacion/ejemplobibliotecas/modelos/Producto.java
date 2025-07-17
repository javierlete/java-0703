package com.ipartek.formacion.ejemplobibliotecas.modelos;

import java.math.BigDecimal;

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
	private String nombre;
	private BigDecimal precio;
}
