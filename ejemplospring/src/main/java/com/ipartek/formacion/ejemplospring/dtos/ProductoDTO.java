package com.ipartek.formacion.ejemplospring.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductoDTO {
	private Long id;
	private String nombre;
	private BigDecimal precio;
}
