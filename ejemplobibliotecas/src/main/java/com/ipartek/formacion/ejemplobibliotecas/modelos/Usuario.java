package com.ipartek.formacion.ejemplobibliotecas.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
	private Long id;
	private String nombre;
	private String email;
	private String password;
}
