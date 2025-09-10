package com.ipartek.formacion.ipartube.dtos;

import java.time.LocalDateTime;

public record ComentarioDto(String usuario, LocalDateTime fechaHora, String texto) {

}
